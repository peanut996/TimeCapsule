package routers

import (
	"github.com/peanut996/timecapsule-go/controllers"
)

func UserRouter() {
	r := Router.Group("/user")
	r.GET("/", controllers.GetAllUser)
	r.POST("/", controllers.AddUser)
	r.GET("/:username", controllers.GetUserByUsername)
	r.PUT("/:username", controllers.UpdateUser)
	r.DELETE("/:username", controllers.DeleteUserByUsername)
}
