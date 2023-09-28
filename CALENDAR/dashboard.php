<?php
//include auth_session.php file on all user panel pages
include("auth_session.php");
?>
<!--
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Dashboard - Client area</title>

</head>

<body>
    <div class="form">
        <p>Hey, !</p>
        <p>You are now user dashboard page.</p>
        <p><a href="logout.php">Logout</a></p>
    </div>
</body>

</html> -->
<!DOCTYPE html>
<!-- Coding By CodingNepal - youtube.com/codingnepal -->
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <title>Dashboard - Client area</title>
    <link rel="stylesheet" href="style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Google Font Link for Icons -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200">
    <script src="script.js" defer></script>
</head>

<body>
    <div class="sidebar">
        <div class="logo">
            <a href=""><img src="Images/Claflin Logo 2.jpg"></a>
            <div class="logo-text full">
                <a href="">
                    <div class="university-name">CLAFLIN University</div>
                    <div class="university-motto">The World Needs Visionaries</div>
                </a>
            </div>


        </div>
        <!-- Home Option -->
        <div class="sidebar--child home">
            <span class="material-symbols-rounded">home</span>
            <p class="full">Home</p>
        </div>
        <!-- Profile Option -->
        <div class="sidebar--child profile">
            <span class="material-symbols-rounded">account_circle</span>
            <p class="full">Profile</p>
        </div>
        <!-- Notifications Option -->
        <div class="sidebar--child notifications">
            <span class="material-symbols-rounded">notifications</span>
            <p class="full">Notifications</p>

        </div>
        <!-- Settings Option -->
        <div class="settings--container">
            <div class="sidebar--child settings">
                <span id="settings-icon" class="material-symbols-rounded">settings</span>
                <p class="full">Settings</p>
                <span id="expand-or-collapse-icon" class="material-symbols-rounded full">expand_more</span>
            </div>
            <div class="settings--dropdown full">
                <div class="chime--icon option">
                    <span id="chime" class="material-symbols-rounded">notifications_active</span>
                    <p id="chime-desc">Chime-on</p>
                </div>
                <a href="logout.php" class="option logout">

                    <span class="material-symbols-rounded">logout</span>
                    <p>Logout</p>

                </a>
            </div>
        </div>


        <div class="message full">
            Hello, <?php echo $_SESSION['username']; ?>
        </div>
    </div>
    <div class="calendar-content">
        <div class="month">
            September
        </div>
        <div class="day">
            24
        </div>
    </div>
    <div class="wrapper">
        <div class="clock">
            <p style="margin-right: 30px;">Current Time</p>
            <p id="demo"></p>
        </div>
        <img src="Images/Claflin logo.jpeg" alt="Claflin Logo" srcset="">
        <div class="calendar-wrapper">
            <div class="calendar-header">
                <p class="current-date"></p>
                <div class="icons">
                    <span id="prev" class="material-symbols-rounded">chevron_left</span>
                    <button onclick=goToCurrentDate()>Today</button>
                    <span id="next" class="material-symbols-rounded">chevron_right</span>
                </div>
            </div>
            <div class="calendar">
                <ul class="weeks">
                    <li>Sun</li>
                    <li>Mon</li>
                    <li>Tue</li>
                    <li>Wed</li>
                    <li>Thu</li>
                    <li>Fri</li>
                    <li>Sat</li>
                </ul>
                <ul class="days"></ul>

            </div>
            <div class="months">
                <div id="jan">January</div>
                <div id="feb">February</div>
                <div id="mar">March</div>
                <div id="apr">April</div>
                <div id="may">May</div>
                <div id="jun">June</div>
                <div id="jul">July</div>
                <div id="aug">August</div>
                <div id="sep">September</div>
                <div id="oct">October</div>
                <div id="nov">November</div>
                <div id="dec">December</div>
            </div>
        </div>




    </div>

</body>

</html>