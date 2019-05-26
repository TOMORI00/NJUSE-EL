package com.example.evolution;

//碰撞箱类
//@Producer:Damon

public class InteractionBox {


    int top;//上边Y值
    int left;//左边X值
    int bottom;//下边Y值
    int right;//右边X值

    int positionX;//中心点X值
    int positionY;//中心点Y值
    int radiusX;//矩形X方向半长
    int radiusY;//矩形Y方向半长

    //构造函数需传入矩形对象四边位置属性
    public InteractionBox(int top, int bottom, int left, int right) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
        this.positionX = (left + right) / 2;
        this.positionY = (top + bottom) / 2;
        this.radiusX = (right - left) / 2;
        this.radiusY = (bottom - top) / 2;
    }

    //判断碰撞，返回字符串形式的碰撞方向，未碰撞返回“none”
    public String interact(InteractionBox b) {

        if((Math.abs(this.positionX - b.positionX) <= (this.radiusX + b.radiusX)) && (Math.abs(this.positionY - b.positionY) <= (this.radiusY + b.radiusY)) && (this.positionY < b.positionY)) {
            return "down";
        }
        else if((Math.abs(this.positionX - b.positionX) <= (this.radiusX + b.radiusX)) && (Math.abs(this.positionY - b.positionY) <= (this.radiusY + b.radiusY)) && (this.positionY > b.positionY)) {
            return "up";
        }
        else if((Math.abs(this.positionX - b.positionX) <= (this.radiusX + b.radiusX)) && (Math.abs(this.positionY - b.positionY) <= (this.radiusY + b.radiusY)) && (this.positionX < b.positionX)) {
            return "right";
        }
        else if((Math.abs(this.positionX - b.positionX) <= (this.radiusX + b.radiusX)) && (Math.abs(this.positionY - b.positionY) <= (this.radiusY + b.radiusY)) && (this.positionX > b.positionX)) {
            return "left";
        }
        else {
            return "none";
        }
    }

}
