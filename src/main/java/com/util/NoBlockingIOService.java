package com.util;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/2/6 
 * @since V1.0
 *  
 */
public class NoBlockingIOService {
    public static void main(String[] args) {

    }

    public static class MutiTimeServer implements Runnable{

        private ServerSocketChannel serverSocketChannel;

        private Selector selector;

        public MutiTimeServer(Integer port) {
            try {
                //1.开启selector和channel
                selector = Selector.open();
                serverSocketChannel = ServerSocketChannel.open();
                //2.绑定端口号并设置为非阻塞
                serverSocketChannel.socket().bind(new InetSocketAddress( port));
                serverSocketChannel.configureBlocking(false);
                //3.注册
                serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            SelectionKey selectionKey = null;
            try {
                //4.轮询selector上的key
                selector.select(1000);
                Set<SelectionKey> selectKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectKeys.iterator();
                while (iterator.hasNext()) {
                    selectionKey = iterator.next();
                    iterator.remove();
                    handleKey(selectionKey);
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (selectionKey != null) {
                    selectionKey.cancel();
                    if (selectionKey.channel() != null) {
                        try {
                            selectionKey.channel().close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }

            if (selector != null) {
                try {
                    selector.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void handleKey(SelectionKey selectionKey) throws IOException {
            if (selectionKey.isValid()) {
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel = null;
                    try {
                        serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);

                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (serverSocketChannel != null) {
                            serverSocketChannel.close();
                        }
                    }
                }

                if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    try {
                        int read = socketChannel.read(byteBuffer);
                        if (read > 0) {
                            byte[] data = new byte[byteBuffer.remaining()];
                            byteBuffer.get(data);
                            System.out.println(new java.lang.String(data, "UTF-8"));
                            doWrite(socketChannel);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        if (socketChannel != null) {
                            socketChannel.close();
                        }
                    }
                }
            }
        }

        private void doWrite(SocketChannel socketChannel) {
            java.lang.String response = new Date(System.currentTimeMillis()).toString();
            ByteBuffer byteBuffer = ByteBuffer.allocate(response.getBytes().length);
            byteBuffer.put(response.getBytes());
            try {
                socketChannel.write(byteBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
