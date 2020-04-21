package models

import (
	"github.com/jinzhu/gorm"
	_"github.com/jinzhu/gorm/dialects/mysql"
	)

var db *gorm.DB

func SetUp(){
	connStr:="peanuts:849421294@(47.100.52.28)/timecapsule?charset=utf8mb4&parseTime=True"
	DB,err := gorm.Open("mysql",connStr)
	if err != nil { panic(err) }
	db=DB
}

func Close(){
	db.Close()
}
