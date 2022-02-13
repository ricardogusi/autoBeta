package gusi.springframework.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

import gusi.springframework.springdata.model.Listener;
import gusi.springframework.springdata.repository.TimeRepository;

@EnableScheduling
@RestController
@RequestMapping("/light")
public class LedController {
	private static GpioPinDigitalOutput pin;

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

	private String ip;

	@Autowired
	private TimeRepository repository;

	GpioController gpio = GpioFactory.getInstance();

	

	public void tooglePin() {
		if (pin == null) {
			pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "Led", PinState.LOW);
		}
		pin.toggle();
	}

	@Scheduled(cron = "#{@startTime1}")
	public void runJobStart1() {
		tooglePin();
	}

	@Scheduled(cron = "#{@stopTime1}")
	public void runJobStop1() {
		tooglePin();
	}

	@Scheduled(cron = "#{@startTime2}")
	public void runJobStart2() {
		tooglePin();
	}

	@Scheduled(cron = "#{@stopTime2}")
	public void runJobStop2() {
		tooglePin();
	}

	@Scheduled(cron = "#{@startTime3}")
	public void runJobStart3() {
		tooglePin();
	}

	@Scheduled(cron = "#{@stopTime3}")
	public void runJobStop3() {
		tooglePin();
	}

	@Scheduled(cron = "#{@scheduledStart1}")
	public void runJobScheduledStart1() {
		tooglePin();
	}

	@Scheduled(cron = "#{@scheduledStop1}")
	public void runJobScheduledStop1() {
		tooglePin();
	}

	@Scheduled(cron = "#{@scheduledStart2}")
	public void runJobScheduledStart2() {
		tooglePin();
	}

	@Scheduled(cron = "#{@scheduledStop2}")
	public void runJobScheduledStop2() {
		tooglePin();
	}

	@RequestMapping
	public void light() {
		tooglePin();
	}

	@GetMapping("/sensor")
	public boolean humiditySensor() {
		Listener listener = new Listener();
		return listener.getStatus();
	}

//------------------------------- SALVAR HORÁRIOS DIÁRIO-------------------------------

	@Bean
	@GetMapping("/time/1/daylystart1")
	public String startTime1() {
		String startTime = repository.daylyStart1();
		this.setDaylyStart1(startTime);
		return repository.daylyStart1();
	}

	@Bean
	@GetMapping("/time/1/daylystop1")
	public String stopTime1() {
		String stopTime = repository.daylyStop1();
		this.setDaylyStop1(stopTime);
		return repository.daylyStop1();
	}

	@Bean
	@GetMapping("/time/1/daylystart2")
	public String startTime2() {
		String startTime = repository.daylyStart2();
		this.setDaylyStart2(startTime);
		return repository.daylyStart2();
	}

	@Bean
	@GetMapping("/time/1/daylystop2")
	public String stopTime2() {
		String stopTime = repository.daylyStop2();
		this.setDaylyStop2(stopTime);
		return repository.daylyStop2();
	}

	@Bean
	@GetMapping("/time/1/daylystart3")
	public String startTime3() {
		String startTime = repository.daylyStart3();
		this.setDaylyStart3(startTime);
		return repository.daylyStart3();
	}

	@Bean
	@GetMapping("/time/1/daylystop3")
	public String stopTime3() {
		String stopTime = repository.daylyStop3();
		this.setDaylyStop3(stopTime);
		return repository.daylyStop3();
	}

	@PostMapping("/time/{userId}/daylystart1")
	public void saveStartTime1(@PathVariable Long userId, @RequestBody String timeUpdate) {
		repository.saveDaylyStart1(userId, timeUpdate);
	}

	@PostMapping("/time/{userId}/daylystop1")
	public void saveStopTime1(@PathVariable Long userId, @RequestBody String timeUpdate) {
		repository.saveDaylyStop1(userId, timeUpdate);
	}

	@PostMapping("/time/{userId}/daylystart2")
	public void saveStartTime2(@PathVariable Long userId, @RequestBody String timeUpdate) {
		repository.saveDaylyStart2(userId, timeUpdate);
	}

	@PostMapping("/time/{userId}/daylystop2")
	public void saveStopTime2(@PathVariable Long userId, @RequestBody String timeUpdate) {
		repository.saveDaylyStop2(userId, timeUpdate);
	}

	@PostMapping("/time/{userId}/daylystart3")
	public void saveStartTime3(@PathVariable Long userId, @RequestBody String timeUpdate) {
		repository.saveDaylyStart3(userId, timeUpdate);
	}

	@PostMapping("/time/{userId}/daylystop3")
	public void saveStopTime3(@PathVariable Long userId, @RequestBody String timeUpdate) {
		repository.saveDaylyStop3(userId, timeUpdate);
	}

//-------------------------------SALVAR HORÁRIOS AGENDADOS-------------------------------
	@Bean
	@GetMapping("/time/{userId}/scheduledstart1")
	public String scheduledStart1() {
		String startTime = repository.scheduledStart1();
		this.setScheduledStart1(startTime);
		return repository.scheduledStart1();
	}

	@Bean
	@GetMapping("/time/{userId}/scheduledstop1")
	public String scheduledStop1() {
		String stopTime = repository.scheduledStop1();
		this.setScheduledStop1(stopTime);
		return repository.scheduledStop1();
	}

	@Bean
	@GetMapping("/time/{userId}/scheduledstart2")
	public String scheduledStart2() {
		String startTime = repository.scheduledStart2();
		this.setScheduledStart2(startTime);
		return repository.scheduledStart2();
	}

	@Bean
	@GetMapping("/time/{userId}/scheduledstop2")
	public String scheduledStop2() {
		String stopTime = repository.scheduledStop2();
		this.setScheduledStop2(stopTime);
		return repository.scheduledStop2();
	}

	@PostMapping("/time/{userId}/scheduledstart1")
	public void saveScheduledStartTime1(@PathVariable Long userId, @RequestBody String timeUpdate) {
		repository.saveScheduledStart1(userId, timeUpdate);
	}

	@PostMapping("/time/{userId}/scheduledstop1")
	public void saveScheduledStopTime1(@PathVariable Long userId, @RequestBody String timeUpdate) {
		repository.saveScheduledStop1(userId, timeUpdate);
	}

	@PostMapping("/time/{userId}/scheduledstart2")
	public void saveScheduledStartTime2(@PathVariable Long userId, @RequestBody String timeUpdate) {
		repository.saveScheduledStart2(userId, timeUpdate);
	}

	@PostMapping("/time/{userId}/scheduledstop2")
	public void saveScheduledStopTime2(@PathVariable Long userId, @RequestBody String timeUpdate) {
		repository.saveScheduledStop2(userId, timeUpdate);
	}

	@GetMapping("/time/{userId}/scheduledday1")
	public String scheduledDay1() {
		return repository.scheduledDay1();
	}

	@GetMapping("/time/{userId}/scheduledmonth1")
	public String scheduledMonth1() {
		return repository.scheduledMonth1();
	}

	@GetMapping("/time/{userId}/scheduledday2")
	public String scheduledDay2() {
		return repository.scheduledDay2();
	}

	@GetMapping("/time/{userId}/scheduledmonth2")
	public String scheduledMonth2() {
		return repository.scheduledMonth2();
	}

	@PostMapping("/time/{userId}/scheduledday1")
	public void saveScheduledDay1(@PathVariable Long userId, @RequestBody String date) {
		repository.saveScheduledDay1(userId, date);
	}

	@PostMapping("/time/{userId}/scheduledmonth1")
	public void saveScheduledMonth1(@PathVariable Long userId, @RequestBody String date) {
		repository.saveScheduledMonth1(userId, date);
	}

	@PostMapping("/time/{userId}/scheduledday2")
	public void saveScheduledDay2(@PathVariable Long userId, @RequestBody String date) {
		repository.saveScheduledDay2(userId, date);
	}

	@PostMapping("/time/{userId}/scheduledmonth2")
	public void saveScheduledMonth2(@PathVariable Long userId, @RequestBody String date) {
		repository.saveScheduledMonth2(userId, date);
	}

	// *************************************************************************************************
	@GetMapping("/time/{userId}/scheduledtime1")
	public String scheduledTime1() {
		return repository.scheduledTime1();
	}

	@GetMapping("/time/{userId}/scheduledtime2")
	public String scheduledTime2() {
		return repository.scheduledTime2();
	}

	@GetMapping("/time/{userId}/scheduledtime3")
	public String scheduledTime3() {
		return repository.scheduledTime3();
	}

	@GetMapping("/time/{userId}/scheduledtime4")
	public String scheduledTime4() {
		return repository.scheduledTime4();
	}

	@PostMapping("/time/{userId}/scheduledtime1")
	public void saveScheduledTime1(@PathVariable Long userId, @RequestBody String date) {
		repository.saveScheduledTime1(userId, date);
	}

	@PostMapping("/time/{userId}/scheduledtime2")
	public void saveScheduledTime2(@PathVariable Long userId, @RequestBody String date) {
		repository.saveScheduledTime2(userId, date);
	}

	@PostMapping("/time/{userId}/scheduledtime3")
	public void saveScheduledTime3(@PathVariable Long userId, @RequestBody String date) {
		repository.saveScheduledTime3(userId, date);
	}

	@PostMapping("/time/{userId}/scheduledtime4")
	public void saveScheduledTime4(@PathVariable Long userId, @RequestBody String date) {
		repository.saveScheduledTime4(userId, date);
	}

	// *************************************************************************************************

	@GetMapping("/time/{userId}/ip")
	public String checkIp() {
		return repository.getIp();
	}

	@PostMapping("/time/{userId}/saveip")
	public void saveIp(@PathVariable Long userId, @RequestBody String ip) {
		repository.saveIp(userId, ip);
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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
