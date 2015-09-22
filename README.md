***************************************************
*                                                 *
*   IF4130 - PENGEMBANGAN APLIKASI TERDISTRIBUSI  *
*             13512052 - 13513601                 *
*         Akhmad Fakhoni Listiyan Dede            *
*                 Try Ajitiono                    *
*                                                 *
***************************************************

REQUIREMENT:
    - MongoDB
    - Thrift Library
    - JDK 1.8
    
How to deploy
    - Open project folder with netbeans with JDK 1.8
    - klik kanan Server.java, run (untuk menjalankan server)
    - klik kanan client.java, run (untuk menjalankan client. Bisa run client beberapa sekaligus)
    - Gunakan /NICK <nama> untuk mengganti nama, apabila hanya /NICK, maka aplikasi akan
      mengassign nick random
    - Gunakan /JOIN <channel> untuk masuk ke dalam channel
    - Gunakan /LEAVE <channel> untuk keluar dari dalam channel
    - Gunakan /QUIT untuk keluar dari aplikasi
    - Gunakan @<nama channel> <pesan> untuk mengirim pesan ke semua orang di dalam channel tersebut
    
Screenshoot:

**Starting server**
![Server Start](screenshoot/1 - server.png?raw=true "Server Start")

**1 Server 3 client init**
![1 Server 3 client init](screenshoot/2 - 1 server 3 client init.png?raw=true "1 Server 3 client init")

**NICK random**
![NICK random](screenshoot/3 - nick random.png?raw=true "NICK random")

**NICK Name**
![NICK name](screenshoot/4 - nick name.png?raw=true "NICK name")
![NICK name](screenshoot/5 - nick name.png?raw=true "NICK name")

**join apapun**
![Join Apapun](screenshoot/6 - join apapun create.png?raw=true "Join Apapun")
![Join Apapun](screenshoot/7 - aji join apapun.png?raw=true "Join Apapun")
![Join Apapun](screenshoot/8 - dede join apapun.png?raw=true "Join Apapun")

**send to apapun**
![Send to Apapun](screenshoot/9 - kiito apapun hallo semua.png?raw=true "Send to Apapun")
![Send to Apapun](screenshoot/10 - aji apapun hallo semua.png?raw=true "Send to Apapun")
![Send to Apapun](screenshoot/11 - dede apapun hallo semua.png?raw=true "Send to Apapun")

**leave apapun**
![Leave to Apapun](screenshoot/12 - kiito leave apapun.png?raw=true "Leave to Apapun")

**dede send apapun**
![Send to Apapun](screenshoot/13 - dede send apapun.png?raw=true "Send to Apapun")

**aji receive from apapun**
![Receive Apapun](screenshoot/14 - aji receive apapun.png?raw=true "Receive Apapun")

**kiito not receive from apapun karena udah leave dan kiito join apapun2**
![Receive to Apapun](screenshoot/15 - kiito not receive apapun.png?raw=true "Receive Apapun")

**dede join apapun2**
![Join Apapun](screenshoot/16 - dede join apapun2.png?raw=true "Join Apapun")

**kiito send to apapun2**
![Send Apapun](screenshoot/17 - kiito send apapun2.png?raw=true "Send Apapun")

**aji send apapun**
![Send Apapun](screenshoot/18 - aji send apapun.png?raw=true "Send Apapun")

**dede receive from apapun dan apapun2, karena masih subscribe di keduanya**
![Receive Apapun](screenshoot/20 - dede receive apapun.png?raw=true "Receive Apapun")
![Receive Apapun2](screenshoot/18 - dede receive apapun2.png?raw=true "Receive Apapun2")

**EXIT**
![EXIT](screenshoot/21 - dede exit.png?raw=true "EXIT")
![EXIT](screenshoot/22 - aji exit.png?raw=true "EXIT")
![EXIT](screenshoot/23 - kiito exit.png?raw=true "EXIT")
