<h1>🔖 ATM PROJECT</h1>

<p>
🎉 Exciting News! 🎉

I am thrilled to announce that my ATM project has finally reached the finish line! After countless hours of development and rigorous testing, it's complete and ready to be showcased. I can't wait for you all to see the fruits of my labor. Stay tuned for more updates!

#Coding #ProjectComplete #ATMProject #Github

</p>

<h2>Brief Background</h2>
<p>
  In the development of this ATM project, I've adopted a comprehensive testing approach to ensure the highest quality. Here's a glimpse into my testing journey:

1. **Static Testing**: I started with static testing, reviewing the code, documentation, and design to catch and rectify errors early in the development process.

2. **Manual Testing**: I performed manual testing to understand the user experience and identify any unexpected behavior.

3. **Unit Testing**: Each component was tested individually to ensure that they function correctly in isolation.

4. **Unit Integration Testing**: After unit testing, I conducted unit integration testing where different components were tested together to check their interoperability.

5. **System Testing**: I carried out system testing to validate the entire system as a whole and ensure it meets the specified requirements.

6. **System Integration Testing**: Lastly, system integration testing was performed to verify that all systems integrated together function correctly.

While I've conducted a variety of tests, it's important to note that no amount of testing can guarantee 100% bug-free software. It's always possible that some bugs may surface in real-world usage. However, rest assured that every effort has been made to deliver a high-quality, reliable ATM project!

</p>

<h2>ATM Project Design / Architecture</h2>

**Screenshot 1**

<img width="384" alt="Screenshot 2023-10-25 at 5 46 37 am" src="https://github.com/de-furkan/atmProject_3/assets/85889728/c3aecaa9-b012-4de0-a1af-522d57f319dc">

**Screenshot 2**

<img width="896" alt="image" src="https://github.com/de-furkan/atmProject_3/assets/85889728/04d33f56-d418-46ab-8d25-d6ca2b36e154">

**Screenshot 3**

<img width="549" alt="image" src="https://github.com/de-furkan/atmProject_3/assets/85889728/043005d6-84a8-462c-92e5-932d8d383a11">

<h2>Getting Started</h2>

<p>
For an optimal and seamless experience with this application, kindly ensure you thoroughly read and follow the instructions provided below. Proper setup is key to unlocking the full potential of this application. Enjoy your journey!
</p>

<h3>Cloning the Project</h3>
<p>
  To begin cloning the GitHub project, simply head over to the repository, and click the big green button that says <code> <> Code </code>. From here, copy the HTTPS URL link, then head over to IntelliJ (since I am using IntelliJ for this project), but the steps will probably be similar on other Integrated Development Environments as well.
</p>

<img width="916" alt="image" src="https://github.com/de-furkan/atmProject_3/assets/85889728/129eb1dc-0f90-435f-b73e-beb80a5b84dd">

<p>
  Next, you need to click on 'Get from VCS', where you will see a new dialog asking for the URL. You need to paste the URL into the URL field. Before doing this, please double-check from the left-hand side that you have successfully logged in to your GitHub profile and have it connected to IntelliJ. Once you have pasted the URL, click the clone button to begin cloning the repository to your IntelliJ.

</p>

<img width="434" alt="image" src="https://github.com/de-furkan/atmProject_3/assets/85889728/e1d9ab1f-26d0-4296-8b7e-3f9466ca44e5">
<img width="795" alt="image" src="https://github.com/de-furkan/atmProject_3/assets/85889728/401ac466-104f-47cf-88ae-fb23bfdeb6e2">


> Please note that when you clone other people's repositories, you may be prompted with a warning message asking if you trust the owner of this project. You need to click 'Trust' or 'Continue' to accept the clone and begin the cloning process.

<h3>Creating the Database</h3>
<p>
Ensure that the pgAdmin PostgreSQL database application is open. Navigate to the left-hand side and under 'Servers', select the appropriate server. Typically, this is labelled as 'PostgreSQL' followed by your version number, as depicted in the image below.
</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/fa196f87-973f-41ba-aa58-1c152e1543dc)

<p>
  Next, perform a right-click on the server you intend to use. From the dropdown menu that appears, hover over the 'Create' option and then select 'Database'.
</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/87561b13-3b87-4672-9f9f-c902d7d5c0ff)

<p>
  Upon opening the 'Create Database' dialog box, your primary task is to provide a name for your database in the 'Database' field. For ease of reference, you might consider naming it 'atmProject3' as shown in the example below. However, feel free to choose a name that suits your preference. By default, 'postgres' is displayed as the Owner, but we'll be modifying this shortly. Click the save button when done, this will create the database and automatically close the 'Create Database' dialog box.

Important: If you're new to JDBC and database connections, it's advisable to keep a record of the database name you've provided. This will be handy later when establishing the connection via the console upon application startup.
</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/5eb8665a-b7e3-4f06-91d3-1dceaf15613a)

<h3>Adding Credentials for Logging into Database</h3>

<p>
  The subsequent step involves creating login credentials. This will allow you to input a username and password for the database, enabling its use within the console. To create these credentials, hover over 'Login/Group Roles' and select 'Login/Group Role...'.

</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/51548e9e-c9e9-43b0-942a-cd7bd0e741b8)

<p>
  This action will open the 'Create - Login/Group Role' dialog box. Here, you're required to input a username in the 'Name' field. You may follow the example provided or choose a username of your preference. Remember to safely note down this username for future reference.
</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/39567d64-e628-4978-9595-b5eabd5e5fd7)

<p>
  Next, navigate to the 'Definition' tab. Here, you'll be asked to enter a password in the 'Password' field. This will serve as your login credentials for the database. You may opt to use 'root' as your password, as shown in the example, or choose a unique password of your own. As always, remember to note this down and keep it secure.

</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/5261412e-d13d-4355-bd30-080ddb39ccbf)

<p>
  Lastly, proceed to the 'Privileges' tab. Here, ensure that the following options are selected and activated:

- Can login?
- Superuser?
- Create roles?
- Create databases?
- Inherit rights from the parent roles?

The final option can remain unchecked and deactivated. Once done, click on the save button.

</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/fd51e9d5-2da8-4976-b1d9-d7af27daaa39)
![image](https://github.com/de-furkan/atmProject_3/assets/85889728/ee36442a-7caf-4b14-a7a6-2990bb15e11f)


<p>
  Once saved, you should see the role created and shown under Login/Group Roles. It will be called by the name you provided upon creating this role. Note: you may see many other names there too, look for the one you created earlier.
</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/06ae64e3-6d28-46c0-bb16-8dd49b5ad72c)

<h3>Connecting Role to Correct Database</h3>
<p>
  Now that the role has been established, it's time to associate it with the appropriate database. This will enable the addition of the username and password to this database. Consequently, we can start utilizing this database through other applications, such as the IntelliJ console, by logging into this database with the linked role.
</p>

<p>
  Now, return to the database you created earlier. Right-click on it, hover over the 'Properties' option in the dropdown menu and click on it.
</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/c26a136d-59e1-4a43-b448-e76cb37e6f95)

<p>
  Upon the opening of the 'Database Properties' dialog box, navigate to the 'General' tab. Here, you'll see the 'Database' name and the 'Owner', which is set to 'postgres' by default. Click on the dropdown box that says 'postgres'. From the list of options, select the role you created earlier. This can be easily identified by the name you assigned to that role in a previous step. Once correctly selected, click save. You can double-check by right-clicking over the database and clicking properties.
</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/b8d714c6-3224-4ca6-b54e-fe3463fbd641)

<h3>Finding the Port Number</h3>

<p>
  The last crucial step is to identify the port number associated with the database for a successful connection. Think of the port number as the door to a house - without the correct door, you may not find the right house. So, right-click on the server name and select 'Properties' from the dropdown menu.
</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/20bfe9e2-b024-40c5-b39b-7434f839b2fa)

<p>
  Upon the appearance of the database dialog box, navigate to the 'Connection' tab from the top menu. Here, you'll find crucial details such as the 'Host name/address' and 'Port number'. It's important to note these down for future reference. Typically, port numbers default to 5433 or 5432. However, regardless of the default, ensure you write down both the port number and the hostname/address on a piece of paper, or somewhere safe to refer to later.

</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/2ffe05c1-e6f9-454e-a299-02be79de1bd7)

<h3>Beginning Setup Within IDE Console</h3>

<p>
  For this demonstration, I'm utilising the IntelliJ IDEA Integrated Development Environment (IDE). However, you're welcome to use an IDE of your preference. Once the project is open, navigate through the following folders: `src > main > java`. Here, locate the 'runner' package and find the `Atm_Runner` class. Run this class to kickstart the application!

</p>

<img width="333" alt="image" src="https://github.com/de-furkan/atmProject_3/assets/85889728/ad18a6ac-3448-4153-a5c1-b22f2c3fafdd">

<h3>Welcome Message</h3>

<p>
  Upon launching the application in your IDE, you'll notice an output similar to the one depicted in the image below. This will also be displayed in your console. You'll be presented with two options: type 'y' to confirm that you've read the GitHub Readme file, or 'n' to decline. Please note, that entering 'n' will prompt the message to reappear until you accept by entering 'y'.
</p>

<img width="884" alt="image" src="https://github.com/de-furkan/atmProject_3/assets/85889728/a45a6b34-ef20-4186-988f-8cbecd1566bc">

<h3>Setting up Database Connection Within the IDE</h3>

<p>
  After confirming the initial message, you'll encounter the next prompt (as shown below). At this juncture, please select option 2 to initiate the setup of your database connection. It's important to note that option 1 will not be applicable in this context, as the database isn't hosted on an online server. The server must be configured locally on your machine.
</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/82e691b5-7b54-4615-be89-90759ca9d820)

<p>
  Upon selecting option 2, you'll be guided through a series of prompts. You'll be asked to enter specific details and press <code>Enter</code> to confirm each one. These prompts are designed to establish a connection with the database you created earlier. You'll be asked for the following information:

- Domain name (essentially the Hostname/address you noted earlier)
- Port number
- Database name
- Username (from the role you created earlier)
- Password (also from the role you created earlier) - Please note, for security reasons, the password will not be visible after setup in the database. This is a default feature in PostgreSQL.
</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/1dcb33d3-c829-4391-adcb-c16549ba9411)

<p>Once all these steps are completed, you should see a message stating:

> "Thank-you. The provided data has been accepted.
Table created successfully."

This indicates that a table has been automatically created within the database connection you set up. </p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/ba75a7d8-bcd0-4ea6-a7d8-38e0ab5fcd35)

<p>
  You might have noticed the message:

> » Please check the table is visible in your database...

At this point, return to your pgAdmin PostgreSQL application and locate the database you created earlier. Click on it to ensure it's selected or highlighted (as shown in the example below). Finally, click on the 'Query Tool', also depicted in the image below.

</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/74a78572-9e3b-4d58-80e2-b7bcee0ba85d)
![image](https://github.com/de-furkan/atmProject_3/assets/85889728/a4f0b32f-c955-4524-a41c-8fa561d352e7)

<p>
Upon selecting the 'Query Tool', a blank page will appear, resembling the image provided below. This is where you'll be able to write and execute SQL queries on your database.
</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/d5ef9dd9-d738-4925-9010-6b955c223e79)

<p>
  The next step involves executing the following SQL query:

```sql
SELECT * FROM registered_users;
```

After entering the SQL query, proceed by clicking the 'Run' button, which is represented by a 'Play' icon located at the top of the page. This will execute the query on your database.
In the bottom section of the page, you'll notice a table with column headers but no data. At this stage, it should appear empty, as illustrated in the second image below.
</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/1b49ad03-8fc1-4a04-8dbc-616b473345eb)

<img width="665" alt="image" src="https://github.com/de-furkan/atmProject_3/assets/85889728/c02c34e6-d1ec-455a-af66-5b6ce5042d6e">

<p>
Next, return to your IDE console and look for the next prompt. This will ask you to confirm that the database has been created and exists within your database system. Once you've verified this, type <code>y</code> and press <code>Enter</code> to confirm. This action will generate some values and populate the table in your database.

Upon seeing the console message:

> 'Data Transfer Completed. Proceeding to next step...'

you can revisit your database application and rerun the SQL query:

```sql
SELECT * FROM registered_users;
```

This will allow you to view the updated table and verify that the new information has been added.
</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/c4e9929b-4c75-4a4d-963d-a5c8ff852b7a)
![image](https://github.com/de-furkan/atmProject_3/assets/85889728/2a1e4af9-bbbc-442f-a09b-7ce233e41906)
![image](https://github.com/de-furkan/atmProject_3/assets/85889728/25f17c68-4594-4d21-aa21-934a4dd71e28)

<h3>Logging In to Your Account</h3>

<p>
  Next, you will encounter a prompt as shown in the image below. In this prompt, you will be asked to enter your `account_number` and `pin`. These details are usually the first entries in the database for your account. 

  In the database, look for the columns that are labelled as `account_number` and `pin`. These are the details you will need to enter in the prompt.
</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/35537155-b83d-4b14-9957-e6552533c0a4)
<img width="372" alt="image" src="https://github.com/de-furkan/atmProject_3/assets/85889728/0f0571b2-48f6-44ce-93f2-4d8bb0d90dd9">

<h2>Congratulations🎉🥳</h2>

<p>
  You are now ready to play around with the application and test it out. Your exploration and feedback are valuable to the continuous improvement of these projects.
</p>

<p>
  Thank you for taking the time to read through this tutorial. Your effort in understanding the workings of this application is greatly appreciated.

Enjoy exploring my projects and happy coding! 😊
</p>
