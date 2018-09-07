<!-- 画面ID： B0102 -->
<!-- 画面名： Homepage(Reader) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<style type="text/css">
<!--
#showframe{
	width: 985px;
}

/** 
 * Slideshow style rules.
 */
#showframe #slideshow {
	margin:0 auto;
	width:640px;
	height:500px;
	background:transparent url(img/bg_slideshow.jpg) no-repeat 0 0;
	position:relative;
}
#showframe #slideshow #slidesContainer {
  margin:0 auto;
  width:560px;
  height:263px;
  overflow:auto; /* allow scrollbar */
  position:relative;
}
#showframe #slideshow #slidesContainer .slide {
  margin:0 auto;
  width:540px; /* reduce by 20 pixels of #slidesContainer to avoid horizontal scroll */
  height:263px;
}

/** 
 * Slideshow controls style rules.
 */
.control {
  display:block;
  width:39px;
  height:263px;
  text-indent:-10000px;
  position:absolute;
  cursor: pointer;
}
#leftControl {
  top:0;
  left:0;
  background:transparent url(img/slider1/control_left.jpg) no-repeat 0 0;
}
#rightControl {
  top:0;
  right:0;
  background:transparent url(img/slider1/control_right.jpg) no-repeat 0 0;
}

/** 
 * Style rules for Demo page
 */
* {
  margin:0;
  padding:0;
  font:normal 11px Verdana, Geneva, sans-serif;
  color:#ccc;
}
a {
  color: #fff;
  font-weight:bold;
  text-decoration:none;
}
a:hover {
  text-decoration:underline;
}
body {
  /*background:#393737 url(img/slider1/bg_body.jpg) repeat-x top left;
	*/
}
#pageContainer {
  margin:0 auto;
  width:960px;
}
#pageContainer h1 {
  display:block;
  width:960px;
  height:114px;
  background:transparent url(img/slider1/bg_pagecontainer_h1.jpg) no-repeat top left;
  text-indent: -10000px;
}
.slide h2, .slide p {
  margin:15px;
}
.slide h2 {
  font:italic 24px Georgia, "Times New Roman", Times, serif;
  color:#ccc;
  letter-spacing:-1px;
}
.slide img {
  float:right;
  margin:0 15px;
}
#footer {
  height:100px;
}
#footer p {
  margin:30px auto 0 auto;
  display:block;
  width:560px;
  height:40px;
}
-->
</style>

<script type="text/javascript">
$(document).ready(function(){
  var currentPosition = 0;
  var slideWidth = 560;
  var slides = $('.slide');
  var numberOfSlides = slides.length;

  // Remove scrollbar in JS
  $('#slidesContainer').css('overflow', 'hidden');

  // Wrap all .slides with #slideInner div
  slides
    .wrapAll('<div id="slideInner"></div>')
    // Float left to display horizontally, readjust .slides width
	.css({
      'float' : 'left',
      'width' : slideWidth
    });

  // Set #slideInner width equal to total width of all slides
  $('#slideInner').css('width', slideWidth * numberOfSlides);

  // Insert controls in the DOM
  $('#slideshow')
    .prepend('<span class="control" id="leftControl">Clicking moves left</span>')
    .append('<span class="control" id="rightControl">Clicking moves right</span>');

  // Hide left arrow control on first load
  manageControls(currentPosition);

  // Create event listeners for .controls clicks
  $('.control')
    .bind('click', function(){
    // Determine new position
	currentPosition = ($(this).attr('id')=='rightControl') ? currentPosition+1 : currentPosition-1;
    
	// Hide / show controls
    manageControls(currentPosition);
    // Move slideInner using margin-left
    $('#slideInner').animate({
      'marginLeft' : slideWidth*(-currentPosition)
    });
  });

  // manageControls: Hides and Shows controls depending on currentPosition
  function manageControls(position){
    // Hide left arrow if position is first slide
	if(position==0){ $('#leftControl').hide() } else{ $('#leftControl').show() }
	// Hide right arrow if position is last slide
    if(position==numberOfSlides-1){ $('#rightControl').hide() } else{ $('#rightControl').show() }
  }	
});
</script>
<form:form id="b0102Form" method="post" modelAttribute="">
<h2 tyle="text-align:center;">工事中</h2>
 <div id="showframe">
  <div id="slideshow">
    <div id="slidesContainer">
	  <c:forEach begin="1" end="6" step="1" varStatus="status">
			<div class="slide" >
	        	<h2>草枕</h2>
	        		<p>
	         		<img src="<c:url value="/img/contents/FL00026.jpg"/>" height="220"/>
	         		山道を登りながら考えた・・・
	        		</p>
	    	</div>
		</c:forEach>
  	</div>
  </div>
 </div>
</form:form>
