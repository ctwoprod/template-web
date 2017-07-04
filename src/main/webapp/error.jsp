<%@ page isErrorPage="true"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/png"
	href="<c:url value='/assets/images/logo-ipems.png'/>"
	sizes="32x32">
<title>template-web Error 500</title>
<meta name="viewport"
	content="initial-scale=1.0,maximum-scale=1.0,user-scalable=no">

<!-- google webfonts -->
<link
	href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:400&amp;subset=latin-ext,latin'
	rel='stylesheet' type='text/css'>

<!-- error page styles -->
<style>
/*! normalize.css v3.0.0 | MIT License | git.io/normalize */
html {
	font-family: sans-serif;
	-ms-text-size-adjust: 100%;
	-webkit-text-size-adjust: 100%
}

body {
	margin: 0
}

article,aside,details,figcaption,figure,footer,header,hgroup,main,nav,section,summary
	{
	display: block
}

audio,canvas,progress,video {
	display: inline-block;
	vertical-align: baseline
}

audio:not ([controls] ){
	display: none;
	height: 0
}

[hidden],badanBahasa {
	display: none
}

a {
	background: 0 0
}

a:active,a:hover {
	outline: 0
}

abbr[title] {
	border-bottom: 1px dotted
}

b,strong {
	font-weight: 700
}

dfn {
	font-style: italic
}

h1 {
	font-size: 2em;
	margin: .67em 0
}

mark {
	background: #ff0;
	color: #000
}

small {
	font-size: 80%
}

sub,sup {
	font-size: 75%;
	line-height: 0;
	position: relative;
	vertical-align: baseline
}

sup {
	top: -.5em
}

sub {
	bottom: -.25em
}

img {
	border: 0
}

svg:not (:root ){
	overflow: hidden
}

figure {
	margin: 1em 40px
}

hr {
	-moz-box-sizing: content-box;
	box-sizing: content-box;
	height: 0
}

pre {
	overflow: auto
}

code,kbd,pre,samp {
	font-family: monospace, monospace;
	font-size: 1em
}

button,input,optgroup,select,textarea {
	color: inherit;
	font: inherit;
	margin: 0
}

button {
	overflow: visible
}

button,select {
	text-transform: none
}

button,html input[type=button],input[type=reset],input[type=submit] {
	-webkit-appearance: button;
	cursor: pointer
}

button[disabled],html input[disabled] {
	cursor: default
}

button::-moz-focus-inner,input::-moz-focus-inner {
	border: 0;
	padding: 0
}

input {
	line-height: normal
}

input[type=checkbox],input[type=radio] {
	box-sizing: border-box;
	padding: 0
}

input[type=number]::-webkit-inner-spin-button,input[type=number]::-webkit-outer-spin-button
	{
	height: auto
}

input[type=search] {
	-webkit-appearance: textfield;
	-moz-box-sizing: content-box;
	-webkit-box-sizing: content-box;
	box-sizing: content-box
}

input[type=search]::-webkit-search-cancel-button,input[type=search]::-webkit-search-decoration
	{
	-webkit-appearance: none
}

fieldset {
	border: 1px solid silver;
	margin: 0 2px;
	padding: .35em .625em .75em
}

legend {
	border: 0;
	padding: 0
}

textarea {
	overflow: auto
}

optgroup {
	font-weight: 700
}

table {
	border-collapse: collapse;
	border-spacing: 0
}

td,th {
	padding: 0
}

body {
	background: #ecf0f1;
	text-align: center;
	padding: 40px 20px
}

.error_heading {
	font: 400 96px/100px "Source Sans Pro", sans-serif;
	margin: 0 0 20px
}

.error_subheading {
	font: 400 32px/38px "Source Sans Pro", sans-serif;
	margin: 0 0 40px
}

.error_subheading strong {
	color: #c0392b
}

p {
	font-size: 14px
}
</style>
</head>
<body>
	<h1 class="error_heading">500</h1>
	<h2 class="error_subheading">
		<%-- Exception Handler --%>
		<font color="red"> <%= exception.toString() %><br>
		</font>
	</h2>
	<p>
		<a href="javascript: history.go(-1)">Go Back</a> or click <a
			href="${pageContext.request.contextPath}/">template-web</a>
	</p>
</body>

</html>



