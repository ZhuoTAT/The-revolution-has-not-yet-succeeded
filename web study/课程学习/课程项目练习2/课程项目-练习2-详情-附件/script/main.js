//实现前进和后退小图片的效果=====
let prev = document.querySelector('.prev');
let next = document.querySelector('.next');
let ul = document.querySelector('.spec-items ul');

prev.onclick = function () {
    ul.style.left = '-38px';
    prev.style.background = 'url(images/disabled-prev.png)';//以html文件为准

}
next.onclick = function () {
    ul.style.left = '-154px';
    next.style.background = 'url(images/disabled-next.png)';
}
/**
 * 可以有过渡效果：
 * 1、数值类的
 * 2、颜色类的
 * 3、转换：平移、旋转、缩放、倾斜
 * 盒子阴影
 */
//实现鼠标放在小图上，边框变红并且上面显示小图
let lis = document.querySelectorAll('.spec-items ul li');
let img = document.querySelector('.main-img  img');
let imgs = document.querySelectorAll('.spec-items img');
for (let i = 0; i < lis.length; i++) {
    lis[i].onmouseover = function () {
        for (let j = 0; j < lis.length; j++) {
            lis[j].className = 'null';
        }
        lis[i].className = 'img-hover';
        //两种表达：
        // 1、img.src=lis[i].children[0].src;
        //2、img.src=imgs[i].src;
        img.src = imgs[i].src;
    }
}
//实现鼠标滑入显示放大镜和大图的效果
let mainImg = document.querySelector('.main-img');//获取中图
let zoomPup = document.querySelector('.zoom-pup');//获取放大镜，中图上面的小黄块
let zoomDiv = document.querySelector('.zoom-div');//获取大图的div
let bigImg = document.querySelector('.zoom-div img')//获取大图
mainImg.onmouseover = function () {
    zoomPup.style.display = 'block';
    zoomDiv.style.display = 'block';
}
//实现鼠标滑出隐藏放大镜和大图的效果
mainImg.onmouseout = function () {
    zoomPup.style.display = 'none';
    zoomDiv.style.display = 'none';
}


//给中图绑定鼠标移动事件
mainImg.onmousemove = function (e) {
    //获取鼠标距离文档顶部(body)的距离pageX
    let pageY = e.pageY;
    //获取中图距离文档顶部(body)的距离  offsetTop
    let offsetTop = mainImg.offsetTop;
    //获取黄色小块的高度的一半
    let h = zoomPup.clientHeight / 2;
    //获取黄色小块顶部距离中图顶部的距离
    let top = pageY - offsetTop - h;
    //判断top
    if (top <= 0) {
        top = 0;
    } else if (top >= mainImg.clientHeight - zoomPup.clientHeight) {
        top = mainImg.clientHeight - zoomPup.clientHeight;
    }
    //将放大镜的定位top设置为黄色小块顶部距离中图顶部的距离。
    zoomPup.style.top = top + 'px';
    //获取鼠标距离文档左边(body)的距离 pageX
    let pageX = e.pageX;
    //获取中图距离文档左边(body)的距离
    let offsetLeft = mainImg.offsetLeft;
    //获取黄色小块宽度的一半
    let w = zoomPup.clientWidth / 2;
    //获取黄色小块距离中图左边的距离
    let left = pageX - offsetLeft - w;
    //判断left
    if (left <= 0) {
        left = 0;
    } else if (left >= mainImg.clientWidth - zoomPup.clientWidth) {
        left = mainImg.clientWidth - zoomPup.clientWidth;
    }
    //将放大镜的定位left设置为黄色小块顶部距离中图顶部的距离。
    zoomPup.style.left = left + 'px';


    let y = top / (mainImg.clientHeight - zoomPup.clientHeight);
    let yy = y * (800 - 540);
    bigImg.style.top = -yy + 'px';//让大图向上走yy的距离
    let x = left / (mainImg.clientWidth - zoomPup.clientWidth);
    let xx = x * (800 - 540);
    bigImg.style.left = -xx + 'px';//让大图向左走xx的距离


}
//实现购物车数量的改变
let reduce = document.querySelector('.reduce');
let add = document.querySelector('.add');
let buyNum = document.querySelector('.buy-num');

add.onclick = function () {
    buyNum.value++;
    if (buyNum.value > 1) {
        reduce.className = 'reduce';
    }
}
reduce.onclick = function () {
    if (buyNum.value > 1) {
        buyNum.value--;
    } else if (buyNum.value <= 1) {
        buyNum.value = 1;
        reduce.className = 'reduce disabled';
    }
}
//实现右边的图上下移动的效果
let shang = document.querySelector('.shang');
let xia = document.querySelector('.xia');
let ul1 = document.querySelector('.track-items ul');
shang.onclick = function () {
    ul1.style.top = '-369px';

}
xia.onclick = function () {
    ul1.style.top = '0px';
}
let lis1 = document.querySelectorAll('.track-items ul li');
for (let i = 0; i < lis.length; i++) {
    lis1[i].onmouseover = function () {
        for (let j = 0; j < lis1.length; j++) {
            lis1[j].className = 'null';
        }
        lis1[i].className = 'img-flow';

    }
}