package hey;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;


public class happy extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					happy frame = new happy();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public happy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JButton btnNewButton = new JButton("New button");
	

				final Timer timer = new Timer();
				
				TimerTask task = new TimerTask() {
					
					int counter = 10;
					@Override
					public void run() {
						if(counter>0) {
							//System.out.println(counter+" seconds");
							counter--;
						}
						else {
							//System.out.println("HAPPY NEW YEAR!");
							btnNewButton.setEnabled(false);
							timer.cancel();
						}
					}		
				};
				
				/*Calendar date = Calendar.getInstance();
				date.set(Calendar.YEAR,2020);
				date.set(Calendar.MONTH,Calendar.DECEMBER);
				date.set(Calendar.DAY_OF_MONTH,31);
				date.set(Calendar.HOUR_OF_DAY,23);
				date.set(Calendar.MINUTE,59);
				date.set(Calendar.SECOND,50);
				date.set(Calendar.MILLISECOND,0);*/
				
				//timer.schedule(task, 0);
				//timer.schedule(task, date.getTime());
				timer.scheduleAtFixedRate(task, 0, 1000);
				//timer.scheduleAtFixedRate(task, date.getTime(), 1000);
			
		
		btnNewButton.setBounds(156, 93, 89, 23);
		contentPane.add(btnNewButton);
	}
}

/*import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class happy {
	
	public static void main(String[] args) {
		
		// Timer = 		A facility for threads to schedule tasks 
		//				for future execution in a background thread
		
		// TimerTask = 	A task that can be scheduled for one-time 
		//				or repeated execution by a Timer
		
		final Timer timer = new Timer();
		
		TimerTask task = new TimerTask() {
			
			int counter = 10;
			@Override
			public void run() {
				if(counter>0) {
					System.out.println(counter+" seconds");
					counter--;
				}
				else {
					System.out.println("HAPPY NEW YEAR!");
					timer.cancel();
				}
			}		
		};
		
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR,2020);
		date.set(Calendar.MONTH,Calendar.DECEMBER);
		date.set(Calendar.DAY_OF_MONTH,31);
		date.set(Calendar.HOUR_OF_DAY,23);
		date.set(Calendar.MINUTE,59);
		date.set(Calendar.SECOND,50);
		date.set(Calendar.MILLISECOND,0);
		
		//timer.schedule(task, 0);
		//timer.schedule(task, date.getTime());
		//timer.scheduleAtFixedRate(task, 0, 1000);
		timer.scheduleAtFixedRate(task, date.getTime(), 1000);
	}

}*/