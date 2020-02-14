<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style type="text/css">

/* -- import Roboto Font ---------------------------- */
@import
	"https://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic&subset=latin,cyrillic"
	;

/* -- You can use this tables in Bootstrap (v3) projects. -- */
//
@import
	"//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css";

/* -- Box model ------------------------------- */
*, *:after, *:before {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

/* -- Demo style ------------------------------- */
html, body {
	position: relative;
	min-height: 100%;
	height: 100%;
}

html {
	position: relative;
	overflow-x: hidden;
	margin: 16px;
	padding: 0;
	min-height: 100%;
	font-size: 62.5%;
	//
	For
	rem
	units
	support
}

body {
	font-family: 'RobotoDraft', 'Roboto', 'Helvetica Neue, Helvetica, Arial',
		sans-serif;
	font-style: normal;
	font-weight: 300;
	font-size: 1.4rem;
	line-height: 2rem;
	letter-spacing: 0.01rem;
	color: #212121;
	background-color: #f5f5f5; // Font Rendering -webkit-font-smoothing :
	antialiased;
	-moz-osx-font-smoothing: grayscale;
	text-rendering: optimizeLegibility;
}

#demo {
	margin: 20px auto;
	max-width: 960px;
}

//
Material Design typography // https: //codepen.io /zavoloklom/pen/IkaFL
#demo h1 {
	font-size: 2.4rem;
	line-height: 3.2rem;
	letter-spacing: 0;
	font-weight: 300;
	color: #212121;
	text-transform: inherit;
	margin-bottom: 1rem;
	text-align: center;
}

#demo h2 {
	font-size: 1.5rem;
	line-height: 2.8rem;
	letter-spacing: 0.01rem;
	font-weight: 400;
	color: #212121;
	text-align: center;
}

//
Material Design shadows // 
.shadow-z-1 {
	-webkit-box-shadow: 0 1px 3px 0 rgba(0, 0, 0, .12), 0 1px 2px 0
		rgba(0, 0, 0, .24);
	-moz-box-shadow: 0 1px 3px 0 rgba(0, 0, 0, .12), 0 1px 2px 0
		rgba(0, 0, 0, .24);
	box-shadow: 0 1px 3px 0 rgba(0, 0, 0, .12), 0 1px 2px 0
		rgba(0, 0, 0, .24);
}

/* -- Material Design Table style -------------- */
//
Variables // --------------------- @table-header-font-weight:      400;
	@table-header-font-color:       #757575 ;

 @table-cell-padding:            1.6rem ;
 @table-condensed-cell-padding:  @table-cell-padding /2;


 @table-bg:                      #fff ;
 @table-bg-accent:               #f5f5f5 ;
 @table-bg-hover:                rgba (0, 0,0,.12 );
 @table-bg-active:               @table-bg-hover ;
 @table-border-color:            #e0e0e0 ; // Mixins // 
	----------------- .transition (@transition) {
	-webkit-transition: @transition;
	-o-transition: @transition;
	transition: @transition;
}

//
Tables // // ----------------- // Baseline styles
.table {
	width: 100%;
	max-width: 100%;
	margin-bottom: 2rem;
	background-color: @table-bg; > thead , > tbody, > tfoot { > tr {
	.transition(all .3s ease); > th , > td { text-align : left;
	padding: @table-cell-padding;
	vertical-align: top;
	border-top: 0;
	.
	transition
	(all
	.3s
	ease);
}

}
}
>
thead>tr>th {
	font-weight: @table-header-font-weight;
	color: @table-header-font-color;
	vertical-align: bottom;
	border-bottom: 1px solid rgba(0, 0, 0, .12);
}

>
caption+thead, > colgroup+thead, > thead:first-child { >
	tr: first-child{
      > th,> td{
        border-top: 0;
}

}
}
>
tbody+tbody {
	border-top: 1px solid rgba(0, 0, 0, .12);
}

//
Nesting
  .table {
	background-color: @table-bg;
}

//
Remove border
  .no-border {
	border: 0;
}

}
//
Condensed table w / half padding
.table-condensed { > thead , > tbody, > tfoot { > tr { > th, > td {
	padding: @table-condensed-cell-padding;
	
}

}
}
}
//
Bordered version // // Add horizontal borders between columns .
.table-bordered {
	border: 0; > thead , > tbody, > tfoot { > tr { > th, > td { border : 0;
	border-bottom: 1px solid@table-border-color;
}

}
}
>
thead>tr { > th , > td { border-bottom-width:2px;
	
}

}
}
//
Zebra-striping // // Default zebra-stripe styles (alternating gray and transparent backgrounds
	)
.table-striped { > tbody > tr:nth-child(odd) {
    > td, > th {
      background-color : @table-bg-accent;
	
}

}
}
//
Hover effect //
.table-hover { > tbody > tr:hover {
    > td, > th {
      background-color : @table-bg-hover;
	
}

}
}
//
Responsive tables (vertical ) // // Wrap your tables in `.table-responsive-vertical
	` and we 'll make them mobile friendly // by vertical table-cell display
	. Only applies <768px . Everything above that will display normally .
	// For correct display you must add 'data-title ' to each 'td '
.table-responsive-vertical {@media screen and (max-width: 768px) { //
	Tighten up spacing>.table {
	margin-bottom: 0;
	background-color: transparent;
	>
	thead
	,
	>
	tfoot
	{
	display
	:
	none;
}

>
tbody {
	display: block; > tr { display : block;
	border: 1px solid@table-border-color;
	border-radius: 2px;
	margin-bottom: @table-cell-padding; > td { background-color : @
	table-bg;
	display: block;
	vertical-align: middle;
	text-align: right;
}

>
td[data-title]:before {
	content: attr(data-title);
	float: left;
	font-size: inherit;
	font-weight: @table-header-font-weight;
	color: @table-header-font-color;
}

}
}
}
//
Special overrides for shadows
    &.shadow-z-1 {
	-webkit-box-shadow: none;
	-moz-box-shadow: none;
	box-shadow: none;
	>
	.
	table
	>
	tbody
	>
	tr
	{
	border
	:
	none;
	.
	shadow-z-1
	();
}

}
//
Special overrides for the bordered tables>.table-bordered {
	border: 0; // Nuke the appropriate borders so that the parent can handle
	them > tbody { > tr { > td { border : 0;
	border-bottom: 1px solid@table-border-color;
}

>
td:last-child {
	border-bottom: 0;
}

}
}
}
//
Special overrides for the striped tables>.table-striped { > tbody > tr >
	td, > tbody > tr:nth-child(odd) {
          background-color : @table-bg;
	
}

>
tbody>tr>td:nth-child(odd) {
	background-color: @table-bg-accent;
}

}
//
Special overrides for hover tables>.table-hover { > tbody { > tr:hover > td,
	> tr :hover {
          background-color : @table-bg;
	
}

>
tr>td:hover {
	background-color: @table-bg-hover;
}

}
}
}
}
//
CSS /LESS Color variations // // --------------------------------
	.table-striped.table-mc-red>tbody>tr:nth-child(odd)>td, .table-striped.table-mc-red>tbody>tr:nth-child(odd)>th
	{
	background-color: #fde0dc;
}

.table-hover.table-mc-red>tbody>tr:hover>td, .table-hover.table-mc-red>tbody>tr:hover>th
	{
	background-color: #f9bdbb;
}

@media screen and (max-width: 767px) {
	.table-responsive-vertical .table-striped.table-mc-red>tbody>tr>td,
		.table-responsive-vertical .table-striped.table-mc-red>tbody>tr:nth-child(odd)
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-striped.table-mc-red>tbody>tr>td:nth-child(odd)
		{
		background-color: #fde0dc;
	}
	.table-responsive-vertical .table-hover.table-mc-red>tbody>tr:hover>td,
		.table-responsive-vertical .table-hover.table-mc-red>tbody>tr:hover {
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-hover.table-mc-red>tbody>tr>td:hover {
		background-color: #f9bdbb;
	}
}

.table-striped.table-mc-pink>tbody>tr:nth-child(odd)>td, .table-striped.table-mc-pink>tbody>tr:nth-child(odd)>th
	{
	background-color: #fce4ec;
}

.table-hover.table-mc-pink>tbody>tr:hover>td, .table-hover.table-mc-pink>tbody>tr:hover>th
	{
	background-color: #f8bbd0;
}

@media screen and (max-width: 767px) {
	.table-responsive-vertical .table-striped.table-mc-pink>tbody>tr>td,
		.table-responsive-vertical .table-striped.table-mc-pink>tbody>tr:nth-child(odd)
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-striped.table-mc-pink>tbody>tr>td:nth-child(odd)
		{
		background-color: #fce4ec;
	}
	.table-responsive-vertical .table-hover.table-mc-pink>tbody>tr:hover>td,
		.table-responsive-vertical .table-hover.table-mc-pink>tbody>tr:hover {
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-hover.table-mc-pink>tbody>tr>td:hover
		{
		background-color: #f8bbd0;
	}
}

.table-striped.table-mc-purple>tbody>tr:nth-child(odd)>td,
	.table-striped.table-mc-purple>tbody>tr:nth-child(odd)>th {
	background-color: #f3e5f5;
}

.table-hover.table-mc-purple>tbody>tr:hover>td, .table-hover.table-mc-purple>tbody>tr:hover>th
	{
	background-color: #e1bee7;
}

@media screen and (max-width: 767px) {
	.table-responsive-vertical .table-striped.table-mc-purple>tbody>tr>td,
		.table-responsive-vertical .table-striped.table-mc-purple>tbody>tr:nth-child(odd)
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-striped.table-mc-purple>tbody>tr>td:nth-child(odd)
		{
		background-color: #f3e5f5;
	}
	.table-responsive-vertical .table-hover.table-mc-purple>tbody>tr:hover>td,
		.table-responsive-vertical .table-hover.table-mc-purple>tbody>tr:hover
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-hover.table-mc-purple>tbody>tr>td:hover
		{
		background-color: #e1bee7;
	}
}

.table-striped.table-mc-deep-purple>tbody>tr:nth-child(odd)>td,
	.table-striped.table-mc-deep-purple>tbody>tr:nth-child(odd)>th {
	background-color: #ede7f6;
}

.table-hover.table-mc-deep-purple>tbody>tr:hover>td, .table-hover.table-mc-deep-purple>tbody>tr:hover>th
	{
	background-color: #d1c4e9;
}

@media screen and (max-width: 767px) {
	.table-responsive-vertical .table-striped.table-mc-deep-purple>tbody>tr>td,
		.table-responsive-vertical .table-striped.table-mc-deep-purple>tbody>tr:nth-child(odd)
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-striped.table-mc-deep-purple>tbody>tr>td:nth-child(odd)
		{
		background-color: #ede7f6;
	}
	.table-responsive-vertical .table-hover.table-mc-deep-purple>tbody>tr:hover>td,
		.table-responsive-vertical .table-hover.table-mc-deep-purple>tbody>tr:hover
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-hover.table-mc-deep-purple>tbody>tr>td:hover
		{
		background-color: #d1c4e9;
	}
}

.table-striped.table-mc-indigo>tbody>tr:nth-child(odd)>td,
	.table-striped.table-mc-indigo>tbody>tr:nth-child(odd)>th {
	background-color: #e8eaf6;
}

.table-hover.table-mc-indigo>tbody>tr:hover>td, .table-hover.table-mc-indigo>tbody>tr:hover>th
	{
	background-color: #c5cae9;
}

@media screen and (max-width: 767px) {
	.table-responsive-vertical .table-striped.table-mc-indigo>tbody>tr>td,
		.table-responsive-vertical .table-striped.table-mc-indigo>tbody>tr:nth-child(odd)
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-striped.table-mc-indigo>tbody>tr>td:nth-child(odd)
		{
		background-color: #e8eaf6;
	}
	.table-responsive-vertical .table-hover.table-mc-indigo>tbody>tr:hover>td,
		.table-responsive-vertical .table-hover.table-mc-indigo>tbody>tr:hover
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-hover.table-mc-indigo>tbody>tr>td:hover
		{
		background-color: #c5cae9;
	}
}

.table-striped.table-mc-blue>tbody>tr:nth-child(odd)>td, .table-striped.table-mc-blue>tbody>tr:nth-child(odd)>th
	{
	background-color: #e7e9fd;
}

.table-hover.table-mc-blue>tbody>tr:hover>td, .table-hover.table-mc-blue>tbody>tr:hover>th
	{
	background-color: #d0d9ff;
}

@media screen and (max-width: 767px) {
	.table-responsive-vertical .table-striped.table-mc-blue>tbody>tr>td,
		.table-responsive-vertical .table-striped.table-mc-blue>tbody>tr:nth-child(odd)
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-striped.table-mc-blue>tbody>tr>td:nth-child(odd)
		{
		background-color: #e7e9fd;
	}
	.table-responsive-vertical .table-hover.table-mc-blue>tbody>tr:hover>td,
		.table-responsive-vertical .table-hover.table-mc-blue>tbody>tr:hover {
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-hover.table-mc-blue>tbody>tr>td:hover
		{
		background-color: #d0d9ff;
	}
}

.table-striped.table-mc-light-blue>tbody>tr:nth-child(odd)>td,
	.table-striped.table-mc-light-blue>tbody>tr:nth-child(odd)>th {
	background-color: #e1f5fe;
}

.table-hover.table-mc-light-blue>tbody>tr:hover>td, .table-hover.table-mc-light-blue>tbody>tr:hover>th
	{
	background-color: #b3e5fc;
}

@media screen and (max-width: 767px) {
	.table-responsive-vertical .table-striped.table-mc-light-blue>tbody>tr>td,
		.table-responsive-vertical .table-striped.table-mc-light-blue>tbody>tr:nth-child(odd)
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-striped.table-mc-light-blue>tbody>tr>td:nth-child(odd)
		{
		background-color: #e1f5fe;
	}
	.table-responsive-vertical .table-hover.table-mc-light-blue>tbody>tr:hover>td,
		.table-responsive-vertical .table-hover.table-mc-light-blue>tbody>tr:hover
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-hover.table-mc-light-blue>tbody>tr>td:hover
		{
		background-color: #b3e5fc;
	}
}

.table-striped.table-mc-cyan>tbody>tr:nth-child(odd)>td, .table-striped.table-mc-cyan>tbody>tr:nth-child(odd)>th
	{
	background-color: #e0f7fa;
}

.table-hover.table-mc-cyan>tbody>tr:hover>td, .table-hover.table-mc-cyan>tbody>tr:hover>th
	{
	background-color: #b2ebf2;
}

@media screen and (max-width: 767px) {
	.table-responsive-vertical .table-striped.table-mc-cyan>tbody>tr>td,
		.table-responsive-vertical .table-striped.table-mc-cyan>tbody>tr:nth-child(odd)
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-striped.table-mc-cyan>tbody>tr>td:nth-child(odd)
		{
		background-color: #e0f7fa;
	}
	.table-responsive-vertical .table-hover.table-mc-cyan>tbody>tr:hover>td,
		.table-responsive-vertical .table-hover.table-mc-cyan>tbody>tr:hover {
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-hover.table-mc-cyan>tbody>tr>td:hover
		{
		background-color: #b2ebf2;
	}
}

.table-striped.table-mc-teal>tbody>tr:nth-child(odd)>td, .table-striped.table-mc-teal>tbody>tr:nth-child(odd)>th
	{
	background-color: #e0f2f1;
}

.table-hover.table-mc-teal>tbody>tr:hover>td, .table-hover.table-mc-teal>tbody>tr:hover>th
	{
	background-color: #b2dfdb;
}

@media screen and (max-width: 767px) {
	.table-responsive-vertical .table-striped.table-mc-teal>tbody>tr>td,
		.table-responsive-vertical .table-striped.table-mc-teal>tbody>tr:nth-child(odd)
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-striped.table-mc-teal>tbody>tr>td:nth-child(odd)
		{
		background-color: #e0f2f1;
	}
	.table-responsive-vertical .table-hover.table-mc-teal>tbody>tr:hover>td,
		.table-responsive-vertical .table-hover.table-mc-teal>tbody>tr:hover {
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-hover.table-mc-teal>tbody>tr>td:hover
		{
		background-color: #b2dfdb;
	}
}

.table-striped.table-mc-green>tbody>tr:nth-child(odd)>td, .table-striped.table-mc-green>tbody>tr:nth-child(odd)>th
	{
	background-color: #d0f8ce;
}

.table-hover.table-mc-green>tbody>tr:hover>td, .table-hover.table-mc-green>tbody>tr:hover>th
	{
	background-color: #a3e9a4;
}

@media screen and (max-width: 767px) {
	.table-responsive-vertical .table-striped.table-mc-green>tbody>tr>td,
		.table-responsive-vertical .table-striped.table-mc-green>tbody>tr:nth-child(odd)
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-striped.table-mc-green>tbody>tr>td:nth-child(odd)
		{
		background-color: #d0f8ce;
	}
	.table-responsive-vertical .table-hover.table-mc-green>tbody>tr:hover>td,
		.table-responsive-vertical .table-hover.table-mc-green>tbody>tr:hover
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-hover.table-mc-green>tbody>tr>td:hover
		{
		background-color: #a3e9a4;
	}
}

.table-striped.table-mc-light-green>tbody>tr:nth-child(odd)>td,
	.table-striped.table-mc-light-green>tbody>tr:nth-child(odd)>th {
	background-color: #f1f8e9;
}

.table-hover.table-mc-light-green>tbody>tr:hover>td, .table-hover.table-mc-light-green>tbody>tr:hover>th
	{
	background-color: #dcedc8;
}

@media screen and (max-width: 767px) {
	.table-responsive-vertical .table-striped.table-mc-light-green>tbody>tr>td,
		.table-responsive-vertical .table-striped.table-mc-light-green>tbody>tr:nth-child(odd)
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-striped.table-mc-light-green>tbody>tr>td:nth-child(odd)
		{
		background-color: #f1f8e9;
	}
	.table-responsive-vertical .table-hover.table-mc-light-green>tbody>tr:hover>td,
		.table-responsive-vertical .table-hover.table-mc-light-green>tbody>tr:hover
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-hover.table-mc-light-green>tbody>tr>td:hover
		{
		background-color: #dcedc8;
	}
}

.table-striped.table-mc-lime>tbody>tr:nth-child(odd)>td, .table-striped.table-mc-lime>tbody>tr:nth-child(odd)>th
	{
	background-color: #f9fbe7;
}

.table-hover.table-mc-lime>tbody>tr:hover>td, .table-hover.table-mc-lime>tbody>tr:hover>th
	{
	background-color: #f0f4c3;
}

@media screen and (max-width: 767px) {
	.table-responsive-vertical .table-striped.table-mc-lime>tbody>tr>td,
		.table-responsive-vertical .table-striped.table-mc-lime>tbody>tr:nth-child(odd)
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-striped.table-mc-lime>tbody>tr>td:nth-child(odd)
		{
		background-color: #f9fbe7;
	}
	.table-responsive-vertical .table-hover.table-mc-lime>tbody>tr:hover>td,
		.table-responsive-vertical .table-hover.table-mc-lime>tbody>tr:hover {
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-hover.table-mc-lime>tbody>tr>td:hover
		{
		background-color: #f0f4c3;
	}
}

.table-striped.table-mc-yellow>tbody>tr:nth-child(odd)>td,
	.table-striped.table-mc-yellow>tbody>tr:nth-child(odd)>th {
	background-color: #fffde7;
}

.table-hover.table-mc-yellow>tbody>tr:hover>td, .table-hover.table-mc-yellow>tbody>tr:hover>th
	{
	background-color: #fff9c4;
}

@media screen and (max-width: 767px) {
	.table-responsive-vertical .table-striped.table-mc-yellow>tbody>tr>td,
		.table-responsive-vertical .table-striped.table-mc-yellow>tbody>tr:nth-child(odd)
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-striped.table-mc-yellow>tbody>tr>td:nth-child(odd)
		{
		background-color: #fffde7;
	}
	.table-responsive-vertical .table-hover.table-mc-yellow>tbody>tr:hover>td,
		.table-responsive-vertical .table-hover.table-mc-yellow>tbody>tr:hover
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-hover.table-mc-yellow>tbody>tr>td:hover
		{
		background-color: #fff9c4;
	}
}

.table-striped.table-mc-amber>tbody>tr:nth-child(odd)>td, .table-striped.table-mc-amber>tbody>tr:nth-child(odd)>th
	{
	background-color: #fff8e1;
}

.table-hover.table-mc-amber>tbody>tr:hover>td, .table-hover.table-mc-amber>tbody>tr:hover>th
	{
	background-color: #ffecb3;
}

@media screen and (max-width: 767px) {
	.table-responsive-vertical .table-striped.table-mc-amber>tbody>tr>td,
		.table-responsive-vertical .table-striped.table-mc-amber>tbody>tr:nth-child(odd)
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-striped.table-mc-amber>tbody>tr>td:nth-child(odd)
		{
		background-color: #fff8e1;
	}
	.table-responsive-vertical .table-hover.table-mc-amber>tbody>tr:hover>td,
		.table-responsive-vertical .table-hover.table-mc-amber>tbody>tr:hover
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-hover.table-mc-amber>tbody>tr>td:hover
		{
		background-color: #ffecb3;
	}
}

.table-striped.table-mc-orange>tbody>tr:nth-child(odd)>td,
	.table-striped.table-mc-orange>tbody>tr:nth-child(odd)>th {
	background-color: #fff3e0;
}

.table-hover.table-mc-orange>tbody>tr:hover>td, .table-hover.table-mc-orange>tbody>tr:hover>th
	{
	background-color: #ffe0b2;
}

@media screen and (max-width: 767px) {
	.table-responsive-vertical .table-striped.table-mc-orange>tbody>tr>td,
		.table-responsive-vertical .table-striped.table-mc-orange>tbody>tr:nth-child(odd)
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-striped.table-mc-orange>tbody>tr>td:nth-child(odd)
		{
		background-color: #fff3e0;
	}
	.table-responsive-vertical .table-hover.table-mc-orange>tbody>tr:hover>td,
		.table-responsive-vertical .table-hover.table-mc-orange>tbody>tr:hover
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-hover.table-mc-orange>tbody>tr>td:hover
		{
		background-color: #ffe0b2;
	}
}

.table-striped.table-mc-deep-orange>tbody>tr:nth-child(odd)>td,
	.table-striped.table-mc-deep-orange>tbody>tr:nth-child(odd)>th {
	background-color: #fbe9e7;
}

.table-hover.table-mc-deep-orange>tbody>tr:hover>td, .table-hover.table-mc-deep-orange>tbody>tr:hover>th
	{
	background-color: #ffccbc;
}

@media screen and (max-width: 767px) {
	.table-responsive-vertical .table-striped.table-mc-deep-orange>tbody>tr>td,
		.table-responsive-vertical .table-striped.table-mc-deep-orange>tbody>tr:nth-child(odd)
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-striped.table-mc-deep-orange>tbody>tr>td:nth-child(odd)
		{
		background-color: #fbe9e7;
	}
	.table-responsive-vertical .table-hover.table-mc-deep-orange>tbody>tr:hover>td,
		.table-responsive-vertical .table-hover.table-mc-deep-orange>tbody>tr:hover
		{
		background-color: @table-bg;
	}
	.table-responsive-vertical .table-hover.table-mc-deep-orange>tbody>tr>td:hover
		{
		background-color: #ffccbc;
	}
}
</style>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!--Here function is passed to the change method-->
<!-- <script>
	$(document).ready(function() {
		$("#dlist").change(function() {
			alert($("#dlist").val());
		});

		$("#year").change(function() {
			$("#quarter").prop("disabled", this.value == -1);
			$("#du").prop("disabled", this.value == -1);
		});
	});
</script> -->

<script>
	$(document).ready(function() {

		if($("#year").val()!=0 && $("#year").val()!=null )
			{
			$("#quarter").prop("disabled", false);
			}
		$("#year").change(function() {
			if($("#year").val()!=0 && $("#year").val()!=null )
			{
			$("#quarter").prop("disabled", false);
			}
			else{
				$("#quarter").prop("disabled", true);
				
				}
		});

		if ($("#empId").length > 0 && $("#empId").val() != "") {
			$("#du").prop("disabled", true);
		} 
		$("#empId").change(function() {

			if ($("#empId").length > 0 && $("#empId").val() != "") {
				$("#du").prop("disabled", true);
			} else {
				$("#du").prop("disabled", false);
			}
		});
	});
</script>
<script type="text/javascript">

/**
 * Created by Kupletsky Sergey on 05.11.14.
 *
 * Material Design Responsive Table
 * Tested on Win8.1 with browsers: Chrome 37, Firefox 32, Opera 25, IE 11, Safari 5.1.7
 * You can use this table in Bootstrap (v3) projects. Material Design Responsive Table CSS-style will override basic bootstrap style.
 * JS used only for table constructor: you don't need it in your project
 */

$(document).ready(function() {

    var table = $('#table');

    // Table bordered
    $('#table-bordered').change(function() {
        var value = $( this ).val();
        table.removeClass('table-bordered').addClass(value);
    });

    // Table striped
    $('#table-striped').change(function() {
        var value = $( this ).val();
        table.removeClass('table-striped').addClass(value);
    });
  
    // Table hover
    $('#table-hover').change(function() {
        var value = $( this ).val();
        table.removeClass('table-hover').addClass(value);
    });

    // Table color
    $('#table-color').change(function() {
        var value = $(this).val();
        table.removeClass(/^table-mc-/).addClass(value);
    });
});

// jQuery’s hasClass and removeClass on steroids
// by Nikita Vasilyev
// https://github.com/NV/jquery-regexp-classes
(function(removeClass) {

	jQuery.fn.removeClass = function( value ) {
		if ( value && typeof value.test === "function" ) {
			for ( var i = 0, l = this.length; i < l; i++ ) {
				var elem = this[i];
				if ( elem.nodeType === 1 && elem.className ) {
					var classNames = elem.className.split( /\s+/ );

					for ( var n = classNames.length; n--; ) {
						if ( value.test(classNames[n]) ) {
							classNames.splice(n, 1);
						}
					}
					elem.className = jQuery.trim( classNames.join(" ") );
				}
			}
		} else {
			removeClass.call(this, value);
		}
		return this;
	}

})(jQuery.fn.removeClass);

</script>
</head>
<body>


	<form:form modelAttribute="filterObj" action="/accenture/timereport"
		method="POST">


			<table class="table table-bordered">
				<tr>
					<td><form:select path="year" id="year" cssClass="form-control" >
							<option selected="selected" disabled="disabled">Year</option>
							<option value="0">All</option>
							<!-- <option value="2018">2018</option>
						<option value="2019">2019</option>
						<option value="2020	">2020</option> -->
							<c:forEach items="${yearObj}" var="itr">
								<form:option label="${itr}" value="${itr}" />
							</c:forEach>
						</form:select></td>
					<td><form:select path="quarter" id="quarter" disabled="true" cssClass="form-control" >
							<option selected="selected" disabled="disabled">Quarter</option>
						 	<option value="all">All</option>
					<!--	<option value="q1">Q1</option>
					<option value="q2">Q2</option>
					<option value="q3">Q3</option>
					<option value="q4">Q4</option> -->
							<c:forEach items="${quarterList}" var="itr">
								<form:option label="${itr}" value="${itr}" />
							</c:forEach>
						</form:select></td>
					<td><form:select path="du" id="du" disabled="false" cssClass="form-control"  >
							<option selected="selected" disabled="disabled">DU</option>
							<option value="all">All</option>

							<!-- <option value="FSBBAR01">FSBBAR01</option>
					<option value="FSBBAR02">FSBBAR02</option>
					<option value="FSBBAR03">FSBBAR03</option>
					<option value="FSBBAR04">FSBBAR04</option>
 -->

							<c:forEach items="${duList}" var="itr">
								<form:option label="${itr}" value="${itr}" />
							</c:forEach>
						</form:select></td>
					<td><form:input path="employeeId" id="empId" cssClass="form-control" placeholder="Employee Id"  /></td>
					 <td><form:checkbox
							path="isCount" id="cnt" label="Get Result as Count"
							value="checked"></form:checkbox>
					<td><input type="submit" id="submit" Class="form-control btn btn-primary"  ></td>
				</tr>
			</table>
		<br>
		<div class="table-responsive-vertical shadow-z-1">
			<c:if test="${not empty list}">
				<table class="table table-hover table-mc-light-blue">



					<tr>
						<th>Employee ID</th>
						<th>BRID ID</th>
						<th>Employee Name</th>
						<th>Accenture Email ID</th>
						<th>Level</th>
						<th>DU</th>
						<th>Status</th>
						<th>Role</th>
						<th>Period</th>


					</tr>



					<c:forEach items="${list}" var="itr">

						<tr>
							<td><c:out value="${itr.employeeId}"></c:out></td>
							<td></td>
							<td><c:out value="${itr.employeeName}"></c:out></td>
							<td></td>
							<td></td>
							<td><c:out value="${itr.DU}"></c:out></td>
							<td></td>
							<td></td>
							<td>
								<%-- <c:out value="${itr.period}"  > --%> <fmt:formatDate
									value="${itr.period}" pattern="yyyy-MM-dd" /> <%-- </c:out> --%>
							</td>

						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
		<c:if test="${not empty reportList}">
			<table class="table table-bordered">



				<tr>
					<th>Employee ID</th>
					<th>BRID ID</th>
					<th>Employee Name</th>
					<th>Accenture Email ID</th>
					<th>Level</th>
					<th>DU</th>
					<th>Status</th>
					<th>Role</th>
					<th>Count</th>

				</tr>



				<c:forEach items="${reportList}" var="itr">

					<tr>
						<td><c:out value="${itr.employeeId }"></c:out></td>
						<td></td>
						<td><c:out value="${itr.employeeName}"></c:out></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><c:out value="${itr.count }"></c:out></td>

					</tr>
				</c:forEach>
			</table>
		</c:if>



	</form:form>

	<!-- <form th:object="${filterObj}" action="/accenture/getAll" method="get">
	<table class="table table-bordered">
		<tr>
			<th><select th:field="*{filterObj.year}" name="year" id="year">
					<option disabled="disabled" selected="selected" value="">Year</option>
					<option value="2018">2018</option>
					<option value="2019">2019</option>
					<option value="2020	">2020</option>
			</select></th>

		<th>
		
		<select name="quarter" id="quarter" disabled="disabled" th:value="${filterObj.quarter}">
					<option disabled="disabled">Quarter</option>
					<option value="q1">Q1</option>
					<option value="q2">Q2</option>
					<option value="q3">Q3</option>
					<option value="q4">Q4</option>
					
			</select>
		</th>
		
		<th>
		
		<select name="du" id="du" disabled="disabled" th:value="${filterObj.du}">
					<option disabled="disabled" selected="selected">DU</option>
					<option value="FSBBAR01">FSBBAR01</option>
					<option value="FSBBAR02">FSBBAR02</option>
					<option value="FSBBAR03">FSBBAR03</option>
					<option value="FSBBAR04">FSBBAR04</option>
					
			</select>
		</th>
		<th> <input type="submit" id="submit"> </th>
		</tr>
		<tr>
			<th>Employee ID</th>
			<th>BRID ID</th>
			<th>Employee Name</th>
			<th>Accenture Email ID</th>
			<th>Level</th>
			<th>DU</th>
			<th>Status</th>
			<th>Role</th>

		

		</tr>


		<tr th:each="emp : ${list}">
			<td th:text="${emp.employeeName}"></td>
			<td th:text="${emp.period}"></td>

		</tr>
	
	</table>
	
</form> -->
</body>
</html>