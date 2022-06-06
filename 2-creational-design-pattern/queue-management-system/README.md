## Problem Specification
Consider a company producing a Queue Management System. The components of the Queue
Management System are described as follows:
1. Display unit for each of the booths in the service center.  
- a. A use ATMega32, Arduino Mega or Raspberry Pi for receiving and processing data from
web-based control unit.
- b. The display system could be LCD panel or LED matrix
2. An application to control the display units over the Internet.
3. The communication system for communication between the display unit and controller application
- a. We can think of WiFi connectivity through broadband service or mobile data service
- b. WiFi service requires WiFi module to communicate with the base station
c. For mobile data we need SIM card for communicating
4. The control unit can control multiple number of display units    

  
You are to implement a web-based system that takes the sales order of the queue management system that
selects the following:    
- The name of the Queue Management System specified as follows:  
    - Deluxe: LCD panel with Raspberry Pi
    - Optimal: Arduino Mega with LED matrix
    - Poor: ATMega32 with LED matrix  
- The communication channel
- The number of display units  
  
You have to determine the cost of the total system as well as description of the system. Cost of the
following must be considered: processor, display, communication module, web-based controller
application, yearly communication cost.  

You have to use creational design patterns to demonstrate the above-mentioned web-based system. Do
not develop the web-based application here. It is sufficient to demonstrate it through regular input and
output command from the prompts.