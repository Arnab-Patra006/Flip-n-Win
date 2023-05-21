var image1 = document.getElementById("c111");
var image2 = document.getElementById("c112");
var image3 = document.getElementById("c113");

var image4 = document.getElementById("c121");
var image5 = document.getElementById("c122");
var image6 = document.getElementById("c123");

var h1c1 = "";
var h1c2 = "";
var h2c1 = "";
var h2c2 = "";

var p1_point = 0;
var p2_point = 0;

var Winner = document.getElementById("res");
var Winner_name="";
var winner_point=0;
var decide = document.getElementById("decide_winner");

// var show_result=<p>The winner is</p>;


fetch("out2.json")
    .then(response => response.json())
    .then(data => {
        console.log(data.ar);
        image1.src = "images/" + `${data.Arnab[0][0]}` + "/" + `${data.Arnab[0][1]}` + ".png";
        image2.src = "images/" + `${data.Arnab[1][0]}` + "/" + `${data.Arnab[1][1]}` + ".png";
        image3.src = "images/" + `${data.Arnab[2][0]}` + "/" + `${data.Arnab[2][1]}` + ".png";
        image4.src = "images/" + `${data.Persistent[0][0]}` + "/" + `${data.Persistent[0][1]}` + ".png";
        image5.src = "images/" + `${data.Persistent[1][0]}` + "/" + `${data.Persistent[1][1]}` + ".png";
        image6.src = "images/" + `${data.Persistent[2][0]}` + "/" + `${data.Persistent[2][1]}` + ".png";


        h1c1 = data.Player1_bestCard[0];
        h1c2 = data.Player1_bestCard[1];

        h2c1 = data.Player2_bestCard[0];
        h2c2 = data.Player2_bestCard[1];

        p1_point = data.Player1_point;
        p2_point = data.Player2_point;

        Winner_name = data.winner;
        winner_point=data.winner_point;
    })
    .catch(error => console.error(error));


var count1 = 0, count2 = 0, count_x = 0, count_y = 0, check1 = 0, check2 = 0;
var f1 = 0, f2 = 0, f3 = 0, f4 = 0, f5 = 0, f6 = 0;
function flip1() {
    if (f1 == 0) {
        count1++;
        f1 = 1;
    }
    const imageContainer = document.querySelector('.image-container');
    imageContainer.addEventListener('click', function () {
        imageContainer.classList.toggle('clicked');
    });
}
function flip2() {
    if (f2 == 0) {
        count1++;
        f2 = 1;
    }
    const imageContainer = document.querySelector('.image-container1');
    imageContainer.addEventListener('click', function () {
        imageContainer.classList.toggle('clicked');
    });
}
function flip3() {
    if (f3 == 0) {
        count1++;
        f3 = 1;
    }
    const imageContainer = document.querySelector('.image-container2');
    imageContainer.addEventListener('click', function () {
        imageContainer.classList.toggle('clicked');
    });
}

function flip4() {

    if (f4 == 0) {
        count2++;
        f4 = 1;
    }
    const imageContainer = document.querySelector('.image-container3');
    imageContainer.addEventListener('click', function () {
        imageContainer.classList.toggle('clicked');
    });
}
function flip5() {
    if (f5 == 0) {
        count2++;
        f5 = 1;
    }
    const imageContainer = document.querySelector('.image-container4');
    imageContainer.addEventListener('click', function () {
        imageContainer.classList.toggle('clicked');
    });
}
function flip6() {
    if (f6 == 0) {
        count2++;
        f6 = 1;
    }
    const imageContainer = document.querySelector('.image-container5');
    imageContainer.addEventListener('click', function () {
        imageContainer.classList.toggle('clicked');
    });
}
function showHighestCard1() {
    if (count1 == 3) {
        check1 = 1;
        document.getElementById("player1_heighest").innerHTML = "<img src='images/" + `${h1c1}` + "/" + `${h1c2}` + ".png' />";
        document.getElementById("player1_points").innerHTML = "Points earned :" + `${p1_point}`;
        count_x = 1;
        if (check1 == 1 && check2 == 1) {
            Winner.innerHTML = "Winner is "+`${Winner_name}`;
        }
    }
}
function showHighestCard2() {
    if (count2 == 3) {
        check2 = 1;
        document.getElementById("player2_heighest").innerHTML = "<img src='images/" + `${h2c1}` + "/" + `${h2c2}` + ".png' />";
        document.getElementById("player2_points").innerHTML = "Points earned :" + `${p2_point}`;
        count_y = 1;
        if (check1 == 1 && check2 == 1) {
            Winner.innerHTML = "Winner is "+`${Winner_name}`+"And his point is :"+`${winner_point}`;
        }
    }
}
function showWinner()
{
    if(check1==1 && check2==1)
    {
        alert("Winner is "+`${Winner_name}`+" And his point is : "+`${winner_point}`);
    }
}
