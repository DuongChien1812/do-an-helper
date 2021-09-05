package com.example.helper.common;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class CommonUtils {
	@Value("${privatekey_string}")
	private String PRIVATEKEY_STRING;
	@Value("${publickey_string}")
	private String PUBLICKEY_STRING;

	public String createToken(String userId, String username, String authRequestID) throws Exception {
		byte[] privateKeyBytes = Base64.getDecoder().decode(PRIVATEKEY_STRING);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		PrivateKey privKey = kf.generatePrivate(keySpec);
//		if (authRequestID == null) {
//			JwtBuilder jwtBuilder = Jwts.builder().setSubject(username).setId(userId).claim("tokenType", "user");
//			return jwtBuilder.signWith(privKey).compact();
//		} else {
		if (authRequestID != null) {
			JwtBuilder jwtBuilder = Jwts.builder().setSubject(username).setId(authRequestID)
					.claim("tokenType", "register")
					.setExpiration(Date.from(ZonedDateTime.now().plusMinutes(1440).toInstant()));
			return jwtBuilder.signWith(privKey).compact();
		}
		return null;
		// JwtBuilder jwtBuilder = Jwts.builder().setSubject(username).setId(userId);
	}

	public UserDetailPrincipal getUserInfo(String jwtToken) throws Exception {
		byte[] publicKeyBytes = Base64.getDecoder().decode(PUBLICKEY_STRING);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		PublicKey publicKey = kf.generatePublic(keySpec);
		Jws<Claims> jws = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(jwtToken);
		UserDetailPrincipal userDetail = new UserDetailPrincipal();
		Claims claims = jws.getBody();
		userDetail.setId(claims.getId());
		userDetail.setUsername(claims.getSubject());
		String tokenType = claims.get("tokenType", String.class);
		if (tokenType.equalsIgnoreCase("register")) {
			userDetail.setAuthenticated(true);
		} else {
			userDetail.setAuthenticated(false);
		}
		return userDetail;
	}

	public KeyPair createNewKeyPair() {
		return Keys.keyPairFor(SignatureAlgorithm.RS256);
	}

	public String getPasswordHash(String username, String password) throws Exception {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest((username + password).getBytes("UTF-8"));
		return Base64.getEncoder().encodeToString(hash);
	}

	public class UserDetailPrincipal {
		private String id;
		private String username;
		private boolean authenticated;

		public boolean isAuthenticated() {
			return authenticated;
		}

		public void setAuthenticated(boolean authenticated) {
			this.authenticated = authenticated;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}
	}

	public String Sha1EncryptText(String sInputText) {
		try {
			return DigestUtils.sha1Hex(sInputText);
		} catch (Exception e) {
			return null;
		}
	}

	public String genSHA256(byte[] passBytes) throws NoSuchAlgorithmException {
		String sha256HashString = "";
		MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
		byte[] passHash = sha256.digest(passBytes);
		sha256HashString = Base64Utils.base64Encode(passHash);
		return sha256HashString;
	}

	public String convertDateToString(Calendar calendar, String format) {
		Date date = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	public static String StringFormatDate(String sdate, String fromDate, String toDate) {
		Date date = null;

		SimpleDateFormat formatter1 = new SimpleDateFormat(fromDate);
		SimpleDateFormat formatter = new SimpleDateFormat(toDate);
		try {
			date = formatter1.parse(sdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return formatter.format(date);
	}

	public static String StringFormatDate(Date sdate, String toDate) {
		Date date = sdate;
		SimpleDateFormat formatter = new SimpleDateFormat(toDate);
		return formatter.format(date);
	}

	public static String formatNumber(Double number) {
		Locale localeEN = new Locale("en", "EN");
		NumberFormat format = NumberFormat.getInstance(localeEN);
		return format.format(number);
	}


	public static String toStringFromJson(JsonObject jsonObject, String feild) {
		return !(jsonObject.get(feild) == null|| jsonObject.get(feild).isJsonNull())? jsonObject.get(feild).getAsString(): "";
	}

	public static Integer toIntFromJson(JsonObject jsonObject, String feild) {
		return !(jsonObject.get(feild) == null|| jsonObject.get(feild).isJsonNull()) ? jsonObject.get(feild).getAsInt() : (int) -1;
	}

	public static Double toDoubleFromJson(JsonObject jsonObject, String feild) {
		return !(jsonObject.get(feild) == null|| jsonObject.get(feild).isJsonNull()) ? jsonObject.get(feild).getAsDouble() : (double) -1;
	}
}
