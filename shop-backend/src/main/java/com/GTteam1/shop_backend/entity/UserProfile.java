package com.GTteam1.shop_backend.entity;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_profile")
public class UserProfile {
			
		@Id
		@Column(name = "id")
	    private String id;

	    @Column(name = "name")
	    private String name;

	    @Column(name = "avatar")
	    private String avatar;

	    @Column(name = "activity_points") 
	    private int activityPoints;
		
		public UserProfile() {} 
		
		public UserProfile(String id, String name, String avatar, int activityPoints) {
			super();
			this.id = id;
			this.name = name;
			this.avatar = avatar;
			this.activityPoints = activityPoints;
		}
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAvatar() {
			return avatar;
		}
		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}
		public int getActivityPoints() {
			return activityPoints;
		}
		public void setActivityPoints(int activityPoints) {
			this.activityPoints = activityPoints;
		}
		
}
