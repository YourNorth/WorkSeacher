<!doctype html>
<html class="no-js" lang="zxx">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Job Board</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- <link rel="manifest" href="site.webmanifest"> -->
    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.png">
    <!-- Place favicon.ico in the root directory -->
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <!-- CSS here -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/owl.carousel.min.css">
    <link rel="stylesheet" href="/css/magnific-popup.css">
    <link rel="stylesheet" href="/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/themify-icons.css">
    <link rel="stylesheet" href="/css/nice-select.css">
    <link rel="stylesheet" href="/css/flaticon.css">
    <link rel="stylesheet" href="/css/gijgo.css">
    <link rel="stylesheet" href="/css/animate.min.css">
    <link rel="stylesheet" href="/css/slicknav.css">

    <link rel="stylesheet" href="/css/style.css">
    <!-- <link rel="stylesheet" href="css/responsive.css"> -->
</head>

<body>
<!--[if lte IE 9]>
<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
<![endif]-->

<!-- header-start -->
<header>
    <div class="header-area ">
        <div id="sticky-header" class="main-header-area">
            <div class="container-fluid ">
                <div class="header_bottom_border">
                    <div class="row align-items-center">
                        <div class="col-xl-3 col-lg-2">
                            <div class="logo">
                                <a href="/index">
                                    <img src="/img/logo.png" alt="">
                                </a>
                            </div>
                        </div>
                        <div class="col-xl-6 col-lg-7">
                            <div class="main-menu  d-none d-lg-block">
                                <nav>
                                    <ul id="navigation">
                                        <li><a href="/index">home</a></li>
                                        <li><a href="/jobs">Browse Job</a></li>
                                        <li><a href="#">pages <i class="ti-angle-down"></i></a>
                                            <ul class="submenu">
                                                <li><a href="/candidate">Candidates </a></li>
                                                <li><a href="/elements">elements</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#">blog <i class="ti-angle-down"></i></a>
                                            <ul class="submenu">
                                                <li><a href="/blog">blog</a></li>
                                                <li><a href="/single_blog">single-blog</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="/contact">Contact</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-3 d-none d-lg-block">
                            <div class="Appointment">
                                <div class="phone_num d-none d-xl-block">
                                    <a href="/my_profile">My profile</a>
                                </div>
                                <div class="d-none d-lg-block">
                                    <a class="boxed-btn3" href="/create_profile">Create profile</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="mobile_menu d-block d-lg-none"></div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</header>
<!-- header-end -->

<!-- bradcam_area  -->
<div class="bradcam_area bradcam_bg_1">
    <div class="container">
        <div class="row">
            <div class="col-xl-12">
                <div class="bradcam_text">
                    <h3>Create profile for candidate</h3>
                </div>
            </div>
        </div>
    </div>
</div>
<!--/ bradcam_area  -->

<!-- catagory_area -->
<form action="/create_profile_candidate" method="post" id="form4">
    <div class="catagory_area">
        <div class="container">
            <div class="row cat_search">
                <div class="col-lg-3 col-md-4">
                    <div class="single_input">
                        <input type="text" autocomplete="off" id="firstName" name="firstName" placeholder="First name">
                    </div>
                    <p></p>
                    <div class="single_input">
                        <input type="text" autocomplete="off" id="lastName" name="lastName" placeholder="Last name">
                    </div>
                    <p></p>
                    <div class="single_input">
                        <input type="text" autocomplete="off" id="country" name="country" placeholder="Country">
                    </div>
                    <p></p>
                    <div class="single_input">
                        <input type="number" min="12" max="100" autocomplete="off" id="age" name="age" placeholder="Age">
                    </div>
                </div>
                <div class="col-lg-3 col-md-4">
                    <div class="single_input">
                        <input type="text" autocomplete="off" id="city" name="city" placeholder="City">
                    </div>
                    <p></p>
                    <div class="single_input">
                        <input type="text" autocomplete="off" id="general_skill" name="general_skill" placeholder="General skill">
                    </div>
                    <p></p>
                    <div class="single_input">
                        <input type="text" autocomplete="off" id="native_language" name="native_language" placeholder="Native language">
                    </div>
                    <p></p>
                    <div class="single_input">
                        <input type="text" autocomplete="off" id="education" name="education" placeholder="Education">
                    </div>
                </div>
                <div class="col-lg-3 col-md-4">
                    <div class="single_input">
                        <select id="gender" name="gender" class="wide" >
                            <option data-display="Gender">Gender</option>
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                        </select>
                    </div>
                </div>
                <div class="col-lg-3 col-md-12">
                    <div class="reset_btn">
                        <button  class="boxed-btn3 w-100" type="submit" onclick="return validateForm()">Create my profile</button>
                    </div>
                    <p></p>
                </div>
                <div class="form-group col-lg-9 col-md-12">
                    <label for="exampleFormControlTextarea1"></label>
                    <textarea placeholder="Description" class="form-control" id="description" name="description" rows="10" cols="90"></textarea>
                </div>
            </div>
    </div>
</form>

<script>
    function validateForm() {
        let firstName = document.getElementById('firstName');
        let lastName = document.getElementById('lastName');
        let country = document.getElementById('country');
        let city = document.getElementById('city');
        let age = document.getElementById('age');
        let general_skill = document.getElementById('general_skill');
        let native_language = document.getElementById('native_language');
        let description = document.getElementById('description');
        let gender = document.getElementById('gender');
        let education = document.getElementById('education');
        let error = '';
        if (firstName.value.length < 2 || firstName.value.length > 50) {
            error += 'First name must be between 2 and 50 characters! \n';
        }
        if (lastName.value.length < 2 || lastName.value.length > 50) {
            error += 'Last name must be between 2 and 50 characters! \n';
        }
        if (country.value.length < 3 || country.value.length > 50) {
            error += 'Country must be between 3 and 50 characters! \n';
        }
        if (city.value.length < 2 || city.value.length > 50) {
            error += 'City must be between 2 and 50 characters! \n';
        }
        if (age.value < 12 || age.value > 100) {
            error += 'Age must be between 12 and 100 characters! \n';
        }
        if (general_skill.value.length < 5 || general_skill.value.length > 50) {
            error += 'General skill must be between 5 and 50 characters! \n';
        }
        if (native_language.value.length < 5 || native_language.value.length > 50) {
            error += 'Native language must be between 5 and 50 characters! \n';
        }
        if (description.value.length < 12 || description.value.length > 255) {
            error += 'Description must be between 12 and 255 characters! \n';
        }
        if (education.value.length < 3 || education.value.length > 50) {
            error += 'Education must be between 3 and 50 characters! \n';
        }
        if (gender.value === "Gender"){
            error += 'Gender field cannot be empty! \n';
        }
        if (error !== '') {
            swal("Oops", error, "error");
            return false;
        } else {
            swal("Good job!", 'Ok', "success");
            let form = document.getElementById("form4");
            form.submit();
        }
    }
</script>

<!-- footer start -->
<footer class="footer">
    <div class="footer_top">
        <div class="container">
            <div class="row">
                <div class="col-xl-3 col-md-6 col-lg-3">
                    <div class="footer_widget wow fadeInUp" data-wow-duration="1s" data-wow-delay=".3s">
                        <div class="footer_logo">
                            <a href="#">
                                <img src="/img/logo.png" alt="">
                            </a>
                        </div>
                        <p>
                            finloan@support.com <br>
                            +10 873 672 6782 <br>
                            600/D, Green road, NewYork
                        </p>
                        <div class="socail_links">
                            <ul>
                                <li>
                                    <a href="#">
                                        <i class="ti-facebook"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-google-plus"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-twitter"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-instagram"></i>
                                    </a>
                                </li>
                            </ul>
                        </div>

                    </div>
                </div>
                <div class="col-xl-2 col-md-6 col-lg-2">
                    <div class="footer_widget wow fadeInUp" data-wow-duration="1.1s" data-wow-delay=".4s">
                        <h3 class="footer_title">
                            Company
                        </h3>
                        <ul>
                            <li><a href="#">About </a></li>
                            <li><a href="#"> Pricing</a></li>
                            <li><a href="#">Carrier Tips</a></li>
                            <li><a href="#">FAQ</a></li>
                        </ul>

                    </div>
                </div>
                <div class="col-xl-3 col-md-6 col-lg-3">
                    <div class="footer_widget wow fadeInUp" data-wow-duration="1.2s" data-wow-delay=".5s">
                        <h3 class="footer_title">
                            Category
                        </h3>
                        <ul>
                            <li><a href="#">Design & Art</a></li>
                            <li><a href="#">Engineering</a></li>
                            <li><a href="#">Sales & Marketing</a></li>
                            <li><a href="#">Finance</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-xl-4 col-md-6 col-lg-4">
                    <div class="footer_widget wow fadeInUp" data-wow-duration="1.3s" data-wow-delay=".6s">
                        <h3 class="footer_title">
                            Subscribe
                        </h3>
                        <form action="#" class="newsletter_form">
                            <input type="text" placeholder="Enter your mail">
                            <button type="submit">Subscribe</button>
                        </form>
                        <p class="newsletter_text">Esteem spirit temper too say adieus who direct esteem esteems
                            luckily.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="copy-right_text wow fadeInUp" data-wow-duration="1.4s" data-wow-delay=".3s">
        <div class="container">
            <div class="footer_border"></div>
            <div class="row">
                <div class="col-xl-12">
                </div>
            </div>
        </div>
    </div>
</footer>
<!--/ footer end  -->

<!-- link that opens popup -->
<!-- JS here -->
<script src="/js/vendor/modernizr-3.5.0.min.js"></script>
<script src="/js/vendor/jquery-1.12.4.min.js"></script>
<script src="/js/popper.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/owl.carousel.min.js"></script>
<script src="/js/isotope.pkgd.min.js"></script>
<script src="/js/ajax-form.js"></script>
<script src="/js/waypoints.min.js"></script>
<script src="/js/jquery.counterup.min.js"></script>
<script src="/js/imagesloaded.pkgd.min.js"></script>
<script src="/js/scrollIt.js"></script>
<script src="/js/jquery.scrollUp.min.js"></script>
<script src="/js/wow.min.js"></script>
<script src="/js/nice-select.min.js"></script>
<script src="/js/jquery.slicknav.min.js"></script>
<script src="/js/jquery.magnific-popup.min.js"></script>
<script src="/js/plugins.js"></script>
<script src="/js/gijgo.min.js"></script>



<!--contact js-->
<script src="/js/contact.js"></script>
<script src="/js/jquery.ajaxchimp.min.js"></script>
<script src="/js/jquery.form.js"></script>
<script src="/js/jquery.validate.min.js"></script>
<script src="/js/mail-script.js"></script>


<script src="/js/main.js"></script>
</body>

</html>