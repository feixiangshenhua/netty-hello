import com.google.protobuf.InvalidProtocolBufferException;
import com.phe1.netty.codec.protobuf.SubscribeReqProto;

import java.util.ArrayList;
import java.util.List;

/**
 * google Protobuf 编码解码测试类
 * Created by xiaoyun on 2016/3/27.
 */
public class TestSubscribeReqProto {

    private static byte[] encode(SubscribeReqProto.SubscribeReq req) {
        return req.toByteArray();
    }

    private static SubscribeReqProto.SubscribeReq decode(byte[] body)
        throws InvalidProtocolBufferException {
        return SubscribeReqProto.SubscribeReq.parseFrom(body);
    }

    private static SubscribeReqProto.SubscribeReq createSubscribeReq() {
        SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
        builder.setSubReqID(1);
        builder.setUserName("xiaoyun");
        builder.setProductName("Netty Book");
        List<String> address = new ArrayList<String>();
        address.add("ShangHai XuHui");
        address.add("BeiJing ShuangQuanPu");
        address.add("HeZe MuDanQu");
        builder.addAllAddress(address);
        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException{
        SubscribeReqProto.SubscribeReq req = createSubscribeReq();
        System.out.println("Before encode : " + req.toString());
        SubscribeReqProto.SubscribeReq req2 = decode(encode(req));
        System.out.println("After decode : " + req.toString());
        System.out.println("Assert equal : --> " + req2.equals(req));
    }
}
