<%-- 
    Document   : MainPage
    Created on : Jul 17, 2023, 11:21:15 AM
    Author     : nkhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="initial-scale=1, width=device-width" />

       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Inter:wght@300;500;700&display=swap" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Racing Sans One:wght@400&display=swap" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Bai Jamjuree:wght@400&display=swap" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=League Gothic:wght@400&display=swap" />
  </head>
 <body>

    <style>
        .header.row {
            background-image: url(./public/image-14@2x.png);
            background-repeat: no-repeat;
            background-size: cover;
            background-position: center;
        }


        .carousel {
            margin-top: 100px;
            /* Điều chỉnh độ cao giữa header và carousel */
        }

        .header-button {
            font-size: 24px;
            color: #f8a4bd;
        }

        .limit-block {
            justify-content: center;
        }

        .title-about-us {

            text-decoration: underline;
            display: inline-block;
            backdrop-filter: blur(6px);
            font-size: 64px;
            font-family: "Racing Sans One";
        }

        .content-about-us {
            font-size: 20px;
            font-family: "Bai Jamjuree";
            text-align: justify;
            display: inline-block;

        }

        .limit-product-title {
            font-family: "Inter";
        }

        .rose-card,
        .lisa-card {
            background: linear-gradient(180deg, #fff, rgba(255, 255, 255, 0));
            color: black;
        }

        .jennie-card,
        .jisoo-card {
            background: linear-gradient(180deg, rgba(255, 255, 255, 0), #fff);
            color: #f061a0;
        }

        .rose-card-img,
        .lisa-card-img,
        .jennie-card-img,
        .jisoo-card-img {
            padding: 2px;
        }

        .shop-char {
            padding-top: 5px;
            font-size: 1.5vw;
            padding: unset;
        }

        .rose-card,
        .lisa-card,
        .jennie-card,
        .jisoo-card {
            justify-content: center;
            align-items: center;
            padding: 2px;
            border: unset;
            border-radius: unset;
        }

        .block-card-char {
            justify-content: center;
        }
    </style>

    <div class="container-fluid">
        <div class="header row" style="height: 500px;">
            <div class="col col-md-12">
                <div class="row">
                    <div class="col-md-3 text-center">
                        <img class="" alt="" src="./public/logo@2x.png" />
                    </div>
                    <div class="mb-5 col-md-6 text-center">
                        <div class="text-center">
                            <button type="button" style="font-size: 3vw;"
                                class="header-button btn btn-default mr-2">About</button>
                            <button type="button" style="font-size: 3vw;"
                                class="header-button btn btn-default mr-2">Shop Store</button>

                            <button type="button" style="font-size: 3vw;"
                                class="header-button btn btn-default mr-2">Auction</button>
                            <button type="button" style="font-size: 3vw;"
                                class="header-button btn btn-default">Home</button>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="row">
                            <div class="col">
                                <button type="button" style="font-size: 3vw;"
                                    class="header-button btn btn-default col-md-5">LOGIN</button>
                                <button type="button" style="white-space: nowrap;font-size: 3vw;"
                                    class="header-button btn btn-default col-md-5">SIGN UP</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row" style="background-color: #f8a4bd; color: #fff;justify-content: space-around;">
            <div class="row justify-content-center col-md-12 ">
                <img src="./public/image-15@2x.png" alt="" style="margin: 5px;">
            </div>
            <div class="row col-md-12  text-center " style="justify-content: flex-start;">
                <div class="col-md-3 " style="align-items: center;">
                    <p class="title-about-us"
                        style="display: flex; white-space: nowrap;font-size: 5vw;align-items: center;justify-content: center;">
                        About Us</p>
                </div>
                <div class="col-md-9 overflow-visible">
                    <p class="content-about-us" style="word-wrap: break-word;font-size: 2vw;">
                        <!-- Thêm 'word-wrap: break-word;' để chữ không tràn ra ngoài màn hình -->
                        With the ever-growing KPop wave and the global popularity of KPop groups, IDOL OSIS was created
                        to cater to the passion and fandom of KPop enthusiasts worldwide. We take pride in being the
                        bridge between fans and their idols, offering a unique and exciting experience for the KPop
                        community.
                        <br><br>
                        IDOL OSIS is a leading online auction platform that specializes in consulting, buying, and
                        auctioning products related to KPop artists. We provide a fair and transparent playground where
                        you can participate in auctions for authentic items from KPop artists, including personal
                        belongings, clothing, accessories, autographed albums, special concert tickets, and much more.
                        <br><br>
                        Join us at IDOL OSIS and discover a colorful world of unique KPop products. Get ready for
                        exciting auction experiences and the chance to own priceless items not found anywhere else. Step
                        into the realm of KPop and unleash your fandom to the fullest!
                    </p>
                </div>
            </div>
        </div>

        <div class="row limit-block" style="background-color: black">
            <div class="col-md-12">
                <p class="limit-product-title text-center" style="color: #fff; font-size: 4vw;white-space: nowrap;">
                    Limited Product</p>
            </div>
            <div class="row justify-content-center">
                <div class="card col-md-3 col-sm-6 col-12 col-lg-3" style="margin: 10px;">
                    <img src="./public/image-16@2x.png" class="card-img-top" alt="...">
                    <div class="card-body d-flex flex-column justify-content-between">
                        <div>
                            <h5 class="card-title" style="font-size: 2vw; padding: 5px;">SAMSUNG GALAXY WATCH ACTIVE X
                                BLACKPINK</h5>
                            <p class="card-text" style="font-size: 2vw; padding: 5px;">14.990.000 VND</p>
                        </div>
                        <div>
                            <a href="#" class="btn btn-primary" style="font-size: 2vw;">Buy Now</a>
                        </div>
                    </div>
                </div>

                <div class="card col-md-3 col-sm-6 col-12 col-lg-3" style="margin: 10px;">
                    <img src="./public/image-16@2x.png" class="card-img-top" alt="...">
                    <div class="card-body d-flex flex-column justify-content-between">
                        <div>
                            <h5 class="card-title" style="font-size: 2vw; padding: 5px;">SAMSUNG GALAXY WATCH ACTIVE X
                                BLACKPINK</h5>
                            <p class="card-text" style="font-size: 2vw; padding: 5px;">14.990.000 VND</p>
                        </div>
                        <div>
                            <a href="#" class="btn btn-primary" style="font-size: 1vw;">Buy Now</a>
                        </div>
                    </div>
                </div>
                <div class="card col-md-3 col-sm-6 col-12 col-lg-3" style="margin: 10px;">
                    <img src="./public/image-16@2x.png" class="card-img-top" alt="...">
                    <div class="card-body d-flex flex-column justify-content-between">
                        <div>
                            <h5 class="card-title" style="font-size: 2vw; padding: 5px;">SAMSUNG GALAXY WATCH ACTIVE X
                                BLACKPINK</h5>
                            <p class="card-text" style="font-size: 2vw; padding: 5px;">14.990.000 VND</p>
                        </div>
                        <div>
                            <a href="#" class="btn btn-primary" style="font-size: 2vw;">Buy Now</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="block-card-char row row-cols-1 row-cols-md-3  text-center shopstort"
            style="background-color: #f8a4bd;">
            <div class="col-12 col-lg-12 col-sm-12 col-md-12 row">
                <div style="display: flex;">
                    <img class="  " alt="" style="width: 185px;height: 135px;" src="./public/logo-shop-store@2x.png" />
                </div>
            </div>

            <div class="mb-4 row col-12 col-lg-12 col-sm-12 col-md-12 ">
                <!-- lisa jisoo rose jennie-->
                <div class="lisa-card card col-3 col-lg-3 col-sm-3 col-md-3 ">
                    <img class="lisa-card-img card-img-top" alt="" src="./public/image-4@2x.png" />
                    <b class="card-body shop-char">
                        <p class="card-title" style="white-space: nowrap;">BLACKPINK × OREO LISA</p>
                        <p class="card-subtitle">5$</p>
                    </b>
                </div>
                <div class="jisoo-card card  col-3 col-lg-3 col-sm-3 col-md-3">
                    <img class="jisoo-card-img card-img-top" alt="" src="./public/image-4@2x.png" />
                    <b class="card-body shop-char">
                        <p class="card-title" style="white-space: nowrap;">BLACKPINK × OREO LISA</p>
                        <p class="card-subtitle">5$</p>
                    </b>
                </div>
                <div class="rose-card card col-3 col-lg-3 col-sm-3 col-md-3 ">
                    <img class="rose-card-img card-img-top" alt="" src="./public/image-4@2x.png" />
                    <b class="card-body shop-char">
                        <p class="card-title" style="white-space: nowrap;">BLACKPINK × OREO LISA</p>
                        <p class="card-subtitle">5$</p>
                    </b>
                </div>
                <div class="jennie-card card  col-3 col-lg-3 col-sm-3 col-md-3 ">
                    <img class="jennie-card-img card-img-top" alt="" src="./public/image-4@2x.png" />
                    <b class="card-body shop-char">
                        <p class="card-title" style="white-space: nowrap;">BLACKPINK × OREO LISA</p>
                        <p class="card-subtitle">5$</p>
                    </b>
                </div>

            </div>

            <div class="row col-md-12" style="margin-top: 15px ; ">

                <div class="card">
                    <img src="./public/image-4@2x.png" class="card-img-top" alt="Product 2">
                    <div class="card-body">
                        <h5><span class="countdown badge bg-success" data-end-time="2025-07-14T12:00:00"
                                style="position: absolute; top: 0; right: 0;"></span></h5>
                        <h5 class="card-title">Product 2</h5>
                        <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                        <p class="card-text">Giá: $75</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <p class="card-text text-center">Số lượt đấu giá: 5</p>
                            <a href="#" class="btn btn-primary">Buy Now</a>
                        </div>
                    </div>
                    <div class="card">
                        <img src="./public/image-4@2x.png" class="card-img-top" alt="Product 2">
                        <div class="card-body">
                            <h5><span class="countdown badge bg-success" data-end-time="2025-07-14T12:00:00"
                                    style="position: absolute; top: 0; right: 0;"></span></h5>
                            <h5 class="card-title">Product 2</h5>
                            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                            <p class="card-text">Giá: $75</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <p class="card-text text-center">Số lượt đấu giá: 5</p>
                                <a href="#" class="btn btn-primary">Buy Now</a>
                            </div>
                        </div>
                        <div class="card">
                            <img src="./public/image-4@2x.png" class="card-img-top" alt="Product 2">
                            <div class="card-body">
                                <h5><span class="countdown badge bg-success" data-end-time="2025-07-14T12:00:00"
                                        style="position: absolute; top: 0; right: 0;"></span></h5>
                                <h5 class="card-title">Product 2</h5>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                                <p class="card-text">Giá: $75</p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <p class="card-text text-center">Số lượt đấu giá: 5</p>
                                    <a href="#" class="btn btn-primary">Buy Now</a>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>


                <!-- example start 🤺🤺🤺🤺 -->


            </div>
            <footer class="container-fluid py-5 bg-dark" style="color: #f061a0;">
                <div class="row">
                    <div class="col-md-3">
                        <h5 class="mb-3 ">Service-Hotline</h5>
                        <p class="">Telefonische Beratung unter:</p>
                        <p class=""><b>+49 (0) 771 / 175 131 69</b></p>
                    </div>
                    <div class="col-md-3">
                        <h5 class="mb-3 ">Shop Service</h5>
                        <ul class="list-unstyled ">
                            <li><a href="#">AGB</a></li>
                            <li><a href="#">Contact</a></li>
                            <li><a href="#">Right of withdrawal</a></li>
                            <li><a href="#">FAQ</a></li>
                            <li><a href="#">Shipping and payment terms</a></li>
                        </ul>
                    </div>
                    <div class="col-md-3">
                        <h5 class="mb-3 ">Informationen</h5>
                        <ul class="list-unstyled ">
                            <li><a href="#">Download area</a></li>
                            <li><a href="#">Imprint</a></li>
                            <li><a href="#">Data protection</a></li>
                            <li><a href="#">Newsletter</a></li>
                            <li><a href="#">Shipment</a></li>
                        </ul>
                    </div>
                    <div class="col-md-3">
                        <h5 class="mb-3 ">Our Company</h5>
                        <div class="row">
                            <div class="col-md-4">
                                <ul class="list-unstyled ">
                                    <li><a href="#">About Us</a></li>
                                    <li><a href="#">Contact</a></li>
                                    <li><a href="#">Guarantee</a></li>
                                </ul>

                            </div>
                        </div>


                    </div>
                </div>
            </footer>










            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
                crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
                integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
                crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
                integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
                crossorigin="anonymous"></script>
</body>
</html>
