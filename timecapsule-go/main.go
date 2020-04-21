package main

import (
	"github.com/peanut996/timecapsule-go/models"
	"github.com/peanut996/timecapsule-go/routers"

	// "./models"
)

func init(){
	models.SetUp()
	routers.SetUp()
}

func main() {
	//r := gin.Default()
	//r.GET("/", func(c *gin.Context) {
	//	c.JSON(200, gin.H{
	//		"message": "Gin start successfully.",
	//	})
	//})
	//r.Run() // listen and serve on 0.0.0.0:8080
}
