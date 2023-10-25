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

#SoftwareTesting #QualityAssurance #ATMProject #Github

</p>

<h2>ATM Project Design / Architecture</h2>

**Screenshot 1**
![abc](https://github.com/de-furkan/atmProject_3/assets/85889728/aa1a326c-716b-4665-95ea-2dfc1e2a1f17)

**Screenshot 2**

<img width="661" alt="Screenshot 2023-10-25 at 3 31 58 am" src="https://github.com/de-furkan/atmProject_3/assets/85889728/f266b90d-2eee-4d69-851e-bdaed8d7d105">

**Screenshot 3**

<img width="561" alt="Screenshot 2023-10-25 at 3 34 06 am" src="https://github.com/de-furkan/atmProject_3/assets/85889728/f5dd3fc7-8ecf-4dd8-957e-7b4a2d20de4d">

<h2>Getting Started</h2>

<p>
For an optimal and seamless experience with this application, kindly ensure you thoroughly read and follow the instructions provided below. Proper setup is key to unlocking the full potential of this application. Enjoy your journey!
</p>

<h3>Creating the Database</h3>
<p>
Ensure that the pgAdmin PostgreSQL database application is open. Navigate to the left-hand side and under 'Servers', select the appropriate server. Typically, this is labelled as 'PostgreSQL' followed by your version number, as depicted in the image below.
</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/dc1205be-4318-47fb-9f6d-af548172722c)

<p>
  Next, perform a right-click on the server you intend to use. From the dropdown menu that appears, hover over the 'Create' option and then select 'Database'.

</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/938382db-09ed-4a5f-97a8-ed3b4252871a)

<p>
  Upon opening the 'Create Database' dialog box, your primary task is to provide a name for your database in the 'Database' field. For ease of reference, you might consider naming it 'atmProject3' as shown in the example below. However, feel free to choose a name that suits your preference. By default, 'postgres' is displayed as the Owner, but we'll be modifying this shortly. Click the save button when done, this will create the database and automatically close the 'Create Database' dialog box.

Important: If you're new to JDBC and database connections, it's advisable to keep a record of the database name you've provided. This will be handy later when establishing the connection via the console upon application startup.
</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/e063830c-b0e5-44c4-a912-8995586c4e0d)

<h3>Adding Credentials for Logging into Database</h3>

<p>
  The subsequent step involves creating login credentials. This will allow you to input a username and password for the database, enabling its use within the console. To create these credentials, hover over 'Login/Group Roles' and select 'Login/Group Role...'.

</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/a1d7b081-bd21-45a4-98e7-5296fd712f8e)

<p>
  This action will open the 'Create - Login/Group Role' dialog box. Here, you're required to input a username in the 'Name' field. You may follow the example provided or choose a username of your preference. Remember to safely note down this username for future reference.
</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/c0622548-0a44-4dca-8065-5ef09b704277)

<p>
  Next, navigate to the 'Definition' tab. Here, you'll be asked to enter a password in the 'Password' field. This will serve as your login credentials for the database. You may opt to use 'root' as your password, as shown in the example, or choose a unique password of your own. As always, remember to note this down and keep it secure.

</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/1e72e1d9-d693-4bc0-ad63-502ebbe461ae)

<p>
  Lastly, proceed to the 'Privileges' tab. Here, ensure that the following options are selected and activated:

- Can login?
- Superuser?
- Create roles?
- Create databases?
- Inherit rights from the parent roles?

The final option can remain unchecked and deactivated. Once done, click on the save button.

</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/d7ef291c-1f5d-4098-9b86-8cc457a0e62a)
![image](https://github.com/de-furkan/atmProject_3/assets/85889728/8c48bc84-4fc0-4532-a795-2b380182b99c)

<p>
  Once saved, you should see the role created and shown under Login/Group Roles. It will be called by the name you provided upon creating this role.
</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/048bbe73-8cd2-43c9-b5b8-b20addcb27a7)

<h3>Connecting Role to Correct Database</h3>
<p>
  Now that the role has been established, it's time to associate it with the appropriate database. This will enable the addition of the username and password to this database. Consequently, we can start utilizing this database through other applications, such as the IntelliJ console, by logging into this database with the linked role.
</p>

<p>
  Now, return to the database you created earlier. Right-click on it, hover over the 'Properties' option in the dropdown menu, and click on it.
</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/9410faf9-1fa7-43a2-95dc-d917d8864776)

<p>
  Upon the opening of the 'Database Properties' dialog box, navigate to the 'General' tab. Here, you'll see the 'Database' name and the 'Owner', which is set to 'postgres' by default. Click on the dropdown box that says 'postgres'. From the list of options, select the role you created earlier. This can be easily identified by the name you assigned to that role in a previous step. Once correctly selected, click save. You can double-check by right-clicking over the database and clicking properties.
</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/da628503-d5ee-4d58-a111-a0ace797f697)

<h3>Finding the Port Number</h3>

<p>
  The last crucial step is to identify the port number associated with the database for a successful connection. Think of the port number as the door to a house - without the correct door, you may not find the right house. So, right-click on the server name and select 'Properties' from the dropdown menu.
</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/ea917f78-385e-4d6b-a1eb-04fcea2a827d)

<p>
  Upon the appearance of the database dialog box, navigate to the 'Connection' tab from the top menu. Here, you'll find crucial details such as the 'Host name/address' and 'Port number'. It's important to note these down for future reference. Typically, port numbers default to 5433 or 5432. However, regardless of the default, ensure you write down both the port number and the host name/address on a piece of paper, or somewhere safe to refer to later.

</p>

![image](https://github.com/de-furkan/atmProject_3/assets/85889728/3e6798a8-d5f3-429e-a9f1-fc91a9280b91)
