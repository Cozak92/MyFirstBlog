package com.cos.blog.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"connected_at",
"properties",
"kakao_account"
})
@Generated("jsonschema2pojo")
public class KakaoProfile {
	
	@JsonProperty("id")
	public Integer id;
	@JsonProperty("connected_at")
	public String connectedAt;
	@JsonProperty("properties")
	public Properties properties;
	@JsonProperty("kakao_account")
	public KakaoAccount kakaoAccount;
	
	@Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"profile_nickname_needs_agreement",
	"profile",
	"has_email",
	"email_needs_agreement",
	"is_email_valid",
	"is_email_verified",
	"email"
	})
	@Generated("jsonschema2pojo")
	public static class KakaoAccount {

		@JsonProperty("profile_nickname_needs_agreement")
		public Boolean profileNicknameNeedsAgreement;
		@JsonProperty("profile")
		public Profile profile;
		@JsonProperty("has_email")
		public Boolean hasEmail;
		@JsonProperty("email_needs_agreement")
		public Boolean emailNeedsAgreement;
		@JsonProperty("is_email_valid")
		public Boolean isEmailValid;
		@JsonProperty("is_email_verified")
		public Boolean isEmailVerified;
		@JsonProperty("email")
		public String email;

	}
	
		@Data
		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonPropertyOrder({
		"nickname"
		})
		@Generated("jsonschema2pojo")
		public static class Profile {
	
		@JsonProperty("nickname")
		public String nickname;

	}
	@Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"nickname"
	})
	@Generated("jsonschema2pojo")
	public static class Properties {

		@JsonProperty("nickname")
		public String nickname;

	}



}








