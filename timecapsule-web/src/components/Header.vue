<template>
    <div class="header">
        <div class="container">
        <a class="logo" href="https://p.timepill.net/"></a>
        </div>
    </div>
</template>

<script>
export default {
  name: 'userheader'
}
</script>

<style scoped>
.header{
    height: 40px;
    background-color: #FAFAFA;
    background-image: linear-gradient(to bottom, #FFFFFF, #F2F2F2);
    background: -webkit-linear-gradient(#FFFFFF,#F2F2F2);
    opacity: 0.99;
    border-bottom: 1px solid #d3d3d3;
    color: #777;
    font-size: 14px;
    margin-bottom: 25px;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    z-index: 1000;
    box-shadow: 0 0 5px #ccc;
    overflow: visible;
}
.container{
    width: 960px;
    margin: 0 auto;
    padding: 0 10px;
}
.header .container {
    overflow: visible;
}
.logo{
    float: left;
    line-height: 38px;
    padding: 0 20px 0 45px;
    font-size: 18px;
    background: url(../assets/logo.gif) no-repeat scroll 0px 10px transparent;
    color: #666;
}
</style>
