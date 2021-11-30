package gusi.springframework.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import gusi.springframework.springdata.model.Times;

public interface TimeRepository extends JpaRepository<Times, Long> {

//	List<Times> findByUserId(Long userId);

	
	//-------------------------------Agendamentos diários  GET------------------------------- 
	@Query(value = "SELECT DAYLY_START1 FROM times T WHERE T.USER_ID = 1", nativeQuery = true)
	String daylyStart1();
	
	@Query(value = "SELECT DAYLY_STOP1 FROM times T WHERE T.USER_ID = 1", nativeQuery = true)
	String daylyStop1();
	
	@Query(value = "SELECT DAYLY_START2 FROM times T WHERE T.USER_ID = 1", nativeQuery = true)
	String daylyStart2();
	
	@Query(value = "SELECT DAYLY_STOP2 FROM times T WHERE T.USER_ID = 1", nativeQuery = true)
	String daylyStop2();
	
	@Query(value = "SELECT DAYLY_START3 FROM times T WHERE T.USER_ID = 1", nativeQuery = true)
	String daylyStart3();
	
	@Query(value = "SELECT DAYLY_STOP3 FROM times T WHERE T.USER_ID = 1", nativeQuery = true)
	String daylyStop3();
	
	//-------------------------------Agendamentos diários POST-------------------------------
	@Transactional
	@Modifying
	@Query(value = "UPDATE times T SET T.DAYLY_START1 = :time WHERE T.USER_ID = :id", nativeQuery = true)
	void saveDaylyStart1(Long id, String time);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE times T SET DAYLY_STOP1 = :time WHERE T.USER_ID = :id", nativeQuery = true)
	void saveDaylyStop1(Long id, String time);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE times T SET DAYLY_START2  = :time WHERE T.USER_ID = :id", nativeQuery = true)
	void saveDaylyStart2(Long id, String time);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE times T SET DAYLY_STOP2 = :time WHERE T.USER_ID = :id", nativeQuery = true)
	void saveDaylyStop2(Long id, String time);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE times T SET DAYLY_START3 = :time  WHERE T.USER_ID = :id", nativeQuery = true)
	void saveDaylyStart3(Long id, String time);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE times T SET DAYLY_STOP3 = :time  WHERE T.USER_ID = :id", nativeQuery = true)
	void saveDaylyStop3(Long id, String time);
	
	

	
	//-------------------------------Agendamentos por dia GET-------------------------------
	@Query(value = "SELECT SCHEDULED_START1 FROM times T WHERE T.USER_ID = 1", nativeQuery = true)
	String scheduledStart1();
	
	@Query(value = "SELECT SCHEDULED_STOP1 FROM times T WHERE T.USER_ID = 1", nativeQuery = true)
	String scheduledStop1();
	
	@Query(value = "SELECT SCHEDULED_START2 FROM times T WHERE T.USER_ID = 1", nativeQuery = true)
	String scheduledStart2();
	
	@Query(value = "SELECT SCHEDULED_STOP2 FROM times T WHERE T.USER_ID = 1", nativeQuery = true)
	String scheduledStop2();
	
	@Query(value = "SELECT SCHEDULED_START3 FROM times T WHERE T.USER_ID = 1", nativeQuery = true)
	String scheduledStart3();
	
	@Query(value = "SELECT SCHEDULED_STOP3 FROM times T WHERE T.USER_ID = 1", nativeQuery = true)
	String scheduledStop3();
	
	@Query(value = "SELECT SCHEDULED_DAY1 FROM times T WHERE T.USER_ID = 1", nativeQuery = true)
	String scheduledDay1();
	
	@Query(value = "SELECT SCHEDULED_MONTH1 FROM times T WHERE T.USER_ID = 1", nativeQuery = true)
	String scheduledMonth1();
	
	@Query(value = "SELECT SCHEDULED_DAY2 FROM times T WHERE T.USER_ID = 1", nativeQuery = true)
	String scheduledDay2();
	
	@Query(value = "SELECT SCHEDULED_MONTH2 FROM times T WHERE T.USER_ID = 1", nativeQuery = true)
	String scheduledMonth2();
	
	@Query(value = "SELECT SCHEDULED_TIME1 FROM times T WHERE T.USER_ID = 1", nativeQuery = true)
	String scheduledTime1();
	
	@Query(value = "SELECT SCHEDULED_TIME2 FROM times T WHERE T.USER_ID = 1", nativeQuery = true)
	String scheduledTime2();

	@Query(value = "SELECT SCHEDULED_TIME3 FROM times T WHERE T.USER_ID = 1", nativeQuery = true)
	String scheduledTime3();

	@Query(value = "SELECT SCHEDULED_TIME4 FROM times T WHERE T.USER_ID = 1", nativeQuery = true)
	String scheduledTime4();	
	
	
	
	//-------------------------------Agendamentos por dia POST-------------------------------
	@Transactional
	@Modifying
	@Query(value = "UPDATE times T SET T.SCHEDULED_START1 = :time WHERE T.USER_ID = :id", nativeQuery = true)
	void saveScheduledStart1(Long id, String time);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE times T SET T.SCHEDULED_STOP1 = :time WHERE T.USER_ID = :id", nativeQuery = true)
	void saveScheduledStop1(Long id, String time);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE times T SET T.SCHEDULED_START2  = :time WHERE T.USER_ID = :id", nativeQuery = true)
	void saveScheduledStart2(Long id, String time);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE times T SET T.SCHEDULED_STOP2 = :time WHERE T.USER_ID = :id", nativeQuery = true)
	void saveScheduledStop2(Long id, String time);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE times T SET T.SCHEDULED_START3 = :time  WHERE T.USER_ID = :id", nativeQuery = true)
	void saveScheduledStart3(Long id, String time);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE times T SET T.SCHEDULED_STOP3 = :time  WHERE T.USER_ID = :id", nativeQuery = true)
	void saveScheduledStop3(Long id, String time);
	
	
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE times T SET T.IP = :ip  WHERE T.USER_ID = :id", nativeQuery = true)
	void saveIp(Long id, String ip);

	
	@Query(value = "SELECT ip FROM times T WHERE T.USER_ID = 1", nativeQuery = true)
	String getIp();

	
	@Transactional
	@Modifying
	@Query(value = "UPDATE times T SET T.SCHEDULED_DAY1 = :date  WHERE T.USER_ID = :id", nativeQuery = true)
	void saveScheduledDay1(Long id, String date);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE times T SET T.SCHEDULED_MONTH1 = :date  WHERE T.USER_ID = :id", nativeQuery = true)
	void saveScheduledMonth1(Long id, String date);
	
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE times T SET T.SCHEDULED_DAY2 = :date  WHERE T.USER_ID = :id", nativeQuery = true)
	void saveScheduledDay2(Long id, String date);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE times T SET T.SCHEDULED_MONTH2 = :date  WHERE T.USER_ID = :id", nativeQuery = true)
	void saveScheduledMonth2(Long id, String date);
	
	
	//****************************************************************************************
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE times T SET T.SCHEDULED_TIME1 = :date  WHERE T.USER_ID = :id", nativeQuery = true)
	void saveScheduledTime1(Long id, String date);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE times T SET T.SCHEDULED_TIME2 = :date  WHERE T.USER_ID = :id", nativeQuery = true)
	void saveScheduledTime2(Long id, String date);
	
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE times T SET T.SCHEDULED_TIME3 = :date  WHERE T.USER_ID = :id", nativeQuery = true)
	void saveScheduledTime3(Long id, String date);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE times T SET T.SCHEDULED_TIME4 = :date  WHERE T.USER_ID = :id", nativeQuery = true)
	void saveScheduledTime4(Long id, String date);

	
	
	

	


	

	
	

}
