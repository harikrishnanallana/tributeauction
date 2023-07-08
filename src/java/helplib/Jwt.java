//package helplib;
//
//import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//
//import java.util.Date;
//
//public class Jwt {
//
//    private static final String SECRET_KEY = "yourSecretKey";
//
//    public static String encodeJwt(String username) {
//        Date now = new Date();
//        Date expiryDate = new Date(now.getTime() + 86400000); // 24 hours
//
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(now)
//                .setExpiration(expiryDate)
//                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
//                .compact();
//    }
//
//    public static String decodeJwt(String token) {
//        Jws<Claims> claims = Jwts.parser()
//                .setSigningKey(SECRET_KEY)
//                .parseClaimsJws(token);
//
//        return claims.getBody().getSubject();
//    }
//}
