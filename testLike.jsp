<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21.11.2018
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>

</head>
<body >
<style>
    div {
        width:50%;
        display: table-cell;
  }
</style>



<button id="but">Выбрать страну</button>
<select id="countries" >
    <option value="opt-1">-</option>

</select>
<select id="regions"></select>
<select id="cities" ></select>

<script type="application/javascript">
    var countries = function() {
        $("#countries").empty();
        $("#regions").empty();
        $('#cities').empty();
        var xwmlhttp;
        if(window.XMLHttpRequest){
            xwmlhttp = new XMLHttpRequest();
        }
        else xwmlhttp = new  ActiveXObject("Microsoft.XMLHTTP");

        xwmlhttp.onreadystatechange = function () {
            if (xwmlhttp.readyState == 4 && xwmlhttp.status == 200){
                var country_arr = xwmlhttp.responseText.split(',');
                for (var i =0; i<country_arr.length-1; i+=2) {
                    $("#countries").append('<option value="' +country_arr[i] +  '">' + country_arr[i+1] +'</option>');
                }
            }
        };
        xwmlhttp.open("GET", "/countryServlet", true);
        xwmlhttp.send("");
    };

    var regions = function () {
        $("#regions").empty();
        $('#cities').empty();
        var country_name = $("select#countries").val();
        if (country_name > 0){
            var xwmlhttp;
            if(window.XMLHttpRequest){
                xwmlhttp = new XMLHttpRequest();
            }
            else xwmlhttp = new  ActiveXObject("Microsoft.XMLHTTP");

            xwmlhttp.onreadystatechange = function () {
                if (xwmlhttp.readyState == 4 && xwmlhttp.status == 200){
                    var reg_arr = xwmlhttp.responseText.split(',');
                    $('#regions').empty();
                    for (var i =0; i<reg_arr.length-1; i+=2) {
                        $("#regions").append('<option value="' +reg_arr[i] +  '">' + reg_arr[i+1] +'</option>');
                    }
                }
            };
            xwmlhttp.open("GET", "/regionServlet?country=" + country_name, true);
            xwmlhttp.send("");
        }
    }

    var cities = function () {
        var region_name = $("select#regions").val();
        if (region_name > 0){
            var xwmlhttp;
            if(window.XMLHttpRequest){
                xwmlhttp = new XMLHttpRequest();
            }
            else xwmlhttp = new  ActiveXObject("Microsoft.XMLHTTP");

            xwmlhttp.onreadystatechange = function () {
                if (xwmlhttp.readyState == 4 && xwmlhttp.status == 200){
                    var city_arr = xwmlhttp.responseText.split(',');
                    $('#cities').empty();
                    for (var i =0; i<city_arr.length-1; i+=2) {
                        $("#cities").append('<option value="' +city_arr[i] +  '">' + city_arr[i+1] +'</option>');
                    }
                }
            };
            xwmlhttp.open("GET", "/cityServlet?region=" + region_name, true);
            xwmlhttp.send("");
        }

    };

    $('#but').click(countries);
    $('#countries').change(regions);
    $('#regions').click(cities)









</script>
</body>
</html>
