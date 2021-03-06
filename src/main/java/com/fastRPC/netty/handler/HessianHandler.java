package com.fastRPC.netty.handler;

import com.fastRPC.client.handler.RpcClientHandler;
import com.fastRPC.serialization.hessian.HessianCodecUtil;
import com.fastRPC.serialization.hessian.HessianDecoder;
import com.fastRPC.serialization.hessian.HessianEncoder;
import com.fastRPC.server.handler.TestServerHandler;
import io.netty.channel.ChannelPipeline;

public class HessianHandler implements NettyRpcHandler {
    @Override
    public void handle(ChannelPipeline pipeline) {
        HessianCodecUtil util = new HessianCodecUtil();
        pipeline.addLast(new HessianEncoder(util))
                .addLast(new HessianDecoder(util))
                .addLast(new RpcClientHandler());
    }
}
