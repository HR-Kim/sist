import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;


public class K_Base64 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        
        String target = "김현룡.....!";
        byte[] targetBytes = target.getBytes();
        
        // Base64 인코딩 ///////////////////////////////////////////////////
        Encoder encoder = java.util.Base64.getEncoder();
        
        // Encoder#encode(byte[] src) :: 바이트배열로 반환
        byte[] encodedBytes = encoder.encode(targetBytes);
        System.out.println(new String(encodedBytes));

        
        // Base64 디코딩 ///////////////////////////////////////////////////
        Decoder decoder = java.util.Base64.getDecoder();
        
        // Decoder#decode(bytes[] src) 
        byte[] decodedBytes1 = decoder.decode(encodedBytes);
        
        // 디코딩한 문자열을 표시
        String decodedString = new String(decodedBytes1);
        System.out.println(decodedString);
    }

}