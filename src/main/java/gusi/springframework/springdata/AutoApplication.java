package gusi.springframework.springdata;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

import gusi.springframework.springdata.model.Listener;

@SpringBootApplication
public class AutoApplication {
	
	
	

	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(AutoApplication.class, args);

		GpioController gpio = GpioFactory.getInstance();

		GpioPinDigitalInput pinWater = gpio.provisionDigitalInputPin(RaspiPin.GPIO_29,
				PinPullResistance.PULL_UP);

		

		 
		pinWater.addListener(new GpioPinListenerDigital() {
				@Override
				public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
					Listener listener = new Listener();
					try {	
						if (event.getState().isHigh()) {
							System.out.println("PRECISA DE ÁGUA");
							listener.setStatus(false);
						} else {
							System.out.println("NA ÁGUA");
							listener.setStatus(true);							
						}
					} catch (Exception e) {
						System.out.println(e);
					}
					
				}
			});
		

	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

	public static void restart() {
		ApplicationArguments args = context.getBean(ApplicationArguments.class);

		Thread thread = new Thread(() -> {
			context.close();
			context = SpringApplication.run(AutoApplication.class, args.getSourceArgs());
		});

		thread.setDaemon(false);
		thread.start();
	}

}
