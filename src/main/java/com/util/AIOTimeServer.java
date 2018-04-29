package com.util;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/2/7 
 * @since V1.0
 *  
 */
public class AIOTimeServer {

    public static void main(String[] args) {
        TimeHandlerTime timeHandlerTime = new TimeHandlerTime();
        new Thread(timeHandlerTime, "THREAD").start();
    }

    public static class TimeHandlerTime implements Runnable{

        AsynchronousServerSocketChannel asynchronousServerSocketChannel;

        CountDownLatch countDownLatch;

        public TimeHandlerTime() {
            try {
                asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
                asynchronousServerSocketChannel.bind(new InetSocketAddress(9998));
                System.out.println("Start....");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void doAccept() {
            asynchronousServerSocketChannel.accept(this, new AcceptTimeHandler());
        }

        @Override
        public void run() {
            countDownLatch = new CountDownLatch(1);
            doAccept();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class AcceptTimeHandler implements CompletionHandler<AsynchronousSocketChannel, TimeHandlerTime>{
        @Override
        public void completed(AsynchronousSocketChannel result, TimeHandlerTime attachment) {
            attachment.asynchronousServerSocketChannel.accept(attachment, this);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            ReadTimeHandler readTimeHandler = new ReadTimeHandler(result);
            result.read(byteBuffer, byteBuffer, readTimeHandler);
        }

        @Override
        public void failed(Throwable exc, TimeHandlerTime attachment) {
            exc.printStackTrace();
            attachment.countDownLatch.countDown();
        }
    }

    public static class  ReadTimeHandler implements CompletionHandler<Integer, ByteBuffer> {

        AsynchronousSocketChannel asynchronousSocketChannel;

        public ReadTimeHandler(AsynchronousSocketChannel asynchronousSocketChannel) {
            if (asynchronousSocketChannel != null) {
                this.asynchronousSocketChannel = asynchronousSocketChannel;
            }
        }

        @Override
        public void completed(Integer result, ByteBuffer attachment) {
            attachment.flip();
            byte[] data = new byte[attachment.remaining()];
            attachment.get(data);
            try {
                String req = new String(data, "UTF-8");
                String currenttime = new Date(System.currentTimeMillis()).toString();
                ByteBuffer response = ByteBuffer.allocate(currenttime.getBytes().length);
                response.put(currenttime.getBytes());
                response.flip();
                asynchronousSocketChannel.write(response, response, new CompletionHandler<Integer, ByteBuffer>() {
                    @Override
                    public void completed(Integer result, ByteBuffer attachment) {
                        if (attachment.hasRemaining()) {
                            asynchronousSocketChannel.write(attachment);
                        }
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                        try {
                            asynchronousSocketChannel.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void failed(Throwable exc, ByteBuffer attachment) {
            exc.printStackTrace();
            try {
                this.asynchronousSocketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
