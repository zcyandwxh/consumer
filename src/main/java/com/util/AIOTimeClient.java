package com.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
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
public class AIOTimeClient {
    public static void main(String[] args) {
        AIOTimeClientHandler aioTimeClientHandler = new AIOTimeClientHandler();
    }

    public static class AIOTimeClientHandler implements CompletionHandler<Void, AIOTimeClientHandler>, Runnable{

        private AsynchronousSocketChannel asynchronousSocketChannel;

        private CountDownLatch countDownLatch;

        @Override
        public void run() {
            try {
                asynchronousSocketChannel = AsynchronousSocketChannel.open();
                countDownLatch = new CountDownLatch(1);
                asynchronousSocketChannel.connect(new InetSocketAddress("127.0.0.1", 9999));
                countDownLatch.await();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    asynchronousSocketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void completed(Void result, AIOTimeClientHandler attachment) {
            String request = "request";
            byte[] req = new byte[request.length()];
            ByteBuffer byteBuffer = ByteBuffer.allocate(request.length());
            byteBuffer.put(req);
            byteBuffer.flip();
            attachment.asynchronousSocketChannel.write(byteBuffer, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer buffer) {
                    if (buffer.hasRemaining()) {
                        asynchronousSocketChannel.write(buffer, buffer, this);
                    } else {
                        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                        asynchronousSocketChannel.read(readBuffer, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                            @Override
                            public void completed(Integer result, ByteBuffer attachment) {
                                attachment.flip();
                                byte[] bytes = new byte[attachment.remaining()];
                                attachment.get(bytes);
                                try {
                                    String response = new String(bytes, "UTF-8");
                                    countDownLatch.countDown();
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void failed(Throwable exc, ByteBuffer attachment) {

                            }
                        });
                    }
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    try {
                        asynchronousSocketChannel.close();
                        countDownLatch.countDown();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

        }

        @Override
        public void failed(Throwable exc, AIOTimeClientHandler attachment) {
            exc.printStackTrace();
            attachment.countDownLatch.countDown();
            try {
                attachment.asynchronousSocketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
