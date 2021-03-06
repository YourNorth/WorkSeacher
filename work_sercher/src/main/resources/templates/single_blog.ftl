<!doctype html>
<html class="no-js" lang="zxx">

<head>
   <meta charset="utf-8">
   <meta http-equiv="x-ua-compatible" content="ie=edge">
   <title>Finloans</title>
   <meta name="description" content="">
   <meta name="viewport" content="width=device-width, initial-scale=1">

   <!-- <link rel="manifest" href="site.webmanifest"> -->
   <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.png">
   <!-- Place favicon.ico in the root directory -->

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
                      <h3>single blog</h3>
                  </div>
              </div>
          </div>
      </div>
  </div>
  <!--/ bradcam_area  -->

   <!--================Blog Area =================-->
   <section class="blog_area single-post-area section-padding">
      <div class="container">
         <div class="row">
            <div class="col-lg-8 posts-list">
               <div class="single-post">
                  <div class="feature-img">
                     <#if blog.picture_id??>
                        <img class="img-fluid" src="/files/${blog.picture_id}" alt="">
                     <#else>
                        <img class="img-fluid" src="/img/blog/single_blog_1.png" alt="">
                     </#if>
                  </div>
                  <div class="blog_details">
                     <h2>${blog.name}
                     </h2>
<#--                     <ul class="blog-info-link mt-3 mb-4">-->
<#--                        <li><a href="#"><i class="fa fa-user"></i> Travel, Lifestyle</a></li>-->
<#--                        <li><a href="#"><i class="fa fa-comments"></i> 03 Comments</a></li>-->
<#--                     </ul>-->
                     <p class="excert">
                        ${blog.text}
                     </p>
                  </div>
               </div>


               <div class="comment-form">
                  <h4>Leave a Reply</h4>
                  <form class="form-contact comment_form" action="#" id="commentForm">
                     <div class="row">
                        <div class="col-12">
                           <div class="form-group">
                              <textarea class="form-control w-100" name="comment" id="comment" cols="30" rows="9"
                                 placeholder="Write Comment"></textarea>
                           </div>
                        </div>
                        <div class="col-sm-6">
                           <div class="form-group">
                              <input class="form-control" name="name" id="name" type="text" placeholder="Name">
                           </div>
                        </div>
                        <div class="col-sm-6">
                           <div class="form-group">
                              <input class="form-control" name="email" id="email" type="email" placeholder="Email">
                           </div>
                        </div>
                        <div class="col-12">
                           <div class="form-group">
                              <input class="form-control" name="website" id="website" type="text" placeholder="Website">
                           </div>
                        </div>
                     </div>
                     <div class="form-group">
                        <button type="submit" class="button button-contactForm btn_1 boxed-btn">Send Message</button>
                     </div>
                  </form>
               </div>
            </div>
            <div class="col-lg-4">
               <div class="blog_right_sidebar">
                  <aside class="single_sidebar_widget search_widget">
                     <form action="#">
                        <div class="form-group">
                           <div class="input-group mb-3">
                              <input type="text" class="form-control" placeholder='Search Keyword'
                                 onfocus="this.placeholder = ''" onblur="this.placeholder = 'Search Keyword'">
                              <div class="input-group-append">
                                 <button class="btn" type="button"><i class="ti-search"></i></button>
                              </div>
                           </div>
                        </div>
                        <button class="button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn"
                           type="submit">Search</button>
                     </form>
                  </aside>



                  <aside class="single_sidebar_widget newsletter_widget">
                     <h4 class="widget_title">Newsletter</h4>
                     <form action="#">
                        <div class="form-group">
                           <input type="email" class="form-control" onfocus="this.placeholder = ''"
                              onblur="this.placeholder = 'Enter email'" placeholder='Enter email' required>
                        </div>
                        <button class="button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn"
                           type="submit">Subscribe</button>
                     </form>
                  </aside>
               </div>
            </div>
         </div>
      </div>
   </section>
   <!--================ Blog Area end =================-->

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