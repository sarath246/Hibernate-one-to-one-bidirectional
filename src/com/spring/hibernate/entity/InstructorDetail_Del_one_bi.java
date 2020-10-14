package com.spring.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail_Del_one_bi {

	// annotate the class as an entity and map to the db table

	// define the fields

	// annotate the fields with db colimn names

	// create constructors

	// generate getters and setters methodes

	// generate tostring() methode

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "youtube_channel")
	private String youtubeChannel;

	@Column(name = "hobby")
	private String hobby;

	// add new field for instructor (also add getters / setters)
	// add @OneToOne annotation

	@OneToOne(mappedBy = "instructorDetail2", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	
	private Instructor2 instructor;

	
	public InstructorDetail_Del_one_bi() {

	}

	public Instructor2 getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor2 instructor) {
		this.instructor = instructor;
	}

	public InstructorDetail_Del_one_bi(String youtubeChannel, String hobby) {

		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}

}
