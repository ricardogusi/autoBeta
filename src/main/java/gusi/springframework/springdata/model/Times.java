package gusi.springframework.springdata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Times {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private Long userId;
	private String daylyStart1;
	private String daylyStop1;
	private String daylyStart2;
	private String daylyStop2;
	private String daylyStart3;
	private String daylyStop3;
	private String scheduledStart1;
	private String scheduledStop1;
	private String scheduledStart2;
	private String scheduledStop2;
	private String scheduledDay1;
	private String scheduledMonth1;
	private String scheduledDay2;
	private String scheduledMonth2;
	private String scheduledTime1;
	private String scheduledTime2;
	private String scheduledTime3;
	private String scheduledTime4;

	public Times() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return getUserId();
	}

	public String getDaylyStart1() {
		return daylyStart1;
	}

	public void setDaylyStart1(String daylyStart1) {
		this.daylyStart1 = daylyStart1;
	}

	public String getDaylyStop1() {
		return daylyStop1;
	}

	public void setDaylyStop1(String daylyStop1) {
		this.daylyStop1 = daylyStop1;
	}

	public String getDaylyStart2() {
		return daylyStart2;
	}

	public void setDaylyStart2(String daylyStart2) {
		this.daylyStart2 = daylyStart2;
	}

	public String getDaylyStop2() {
		return daylyStop2;
	}

	public void setDaylyStop2(String daylyStop2) {
		this.daylyStop2 = daylyStop2;
	}

	public String getDaylyStart3() {
		return daylyStart3;
	}

	public void setDaylyStart3(String daylyStart3) {
		this.daylyStart3 = daylyStart3;
	}

	public String getDaylyStop3() {
		return daylyStop3;
	}

	public void setDaylyStop3(String daylyStop3) {
		this.daylyStop3 = daylyStop3;
	}

	public String getScheduledStart1() {
		return scheduledStart1;
	}

	public void setScheduledStart1(String scheduledStart1) {
		this.scheduledStart1 = scheduledStart1;
	}

	public String getScheduledStop1() {
		return scheduledStop1;
	}

	public void setScheduledStop1(String scheduledStop1) {
		this.scheduledStop1 = scheduledStop1;
	}

	public String getScheduledStart2() {
		return scheduledStart2;
	}

	public void setScheduledStart2(String scheduledStart2) {
		this.scheduledStart2 = scheduledStart2;
	}

	public String getScheduledStop2() {
		return scheduledStop2;
	}

	public void setScheduledStop2(String scheduledStop2) {
		this.scheduledStop2 = scheduledStop2;
	}

	public String getScheduledDay1() {
		return scheduledDay1;
	}

	public void setScheduledDay1(String scheduledDay1) {
		this.scheduledDay1 = scheduledDay1;
	}

	public String getScheduledMonth1() {
		return scheduledMonth1;
	}

	public void setScheduledMonth1(String scheduledMonth1) {
		this.scheduledMonth1 = scheduledMonth1;
	}

	public String getScheduledDay2() {
		return scheduledDay2;
	}

	public void setScheduledDay2(String scheduledDay2) {
		this.scheduledDay2 = scheduledDay2;
	}

	public String getScheduledMonth2() {
		return scheduledMonth2;
	}

	public void setScheduledMonth2(String scheduledMonth2) {
		this.scheduledMonth2 = scheduledMonth2;
	}

	public void setScheduledTime1(String scheduledTime1) {
		this.scheduledTime1 = scheduledTime1;
	}

	public void setScheduledTime2(String scheduledTime2) {
		this.scheduledTime2 = scheduledTime2;
	}

	public void setScheduledTime3(String scheduledTime3) {
		this.scheduledTime3 = scheduledTime3;
	}

	public void setScheduledTime4(String scheduledTime4) {
		this.scheduledTime4 = scheduledTime4;
	}

	public String getScheduledTime1() {
		return scheduledTime1;
	}

	public String getScheduledTime2() {
		return scheduledTime2;
	}

	public String getScheduledTime3() {
		return scheduledTime3;
	}

	public String getScheduledTime4() {
		return scheduledTime4;
	}

}
