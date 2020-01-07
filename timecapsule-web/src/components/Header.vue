<template>
    <div class="header">
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
</style>
