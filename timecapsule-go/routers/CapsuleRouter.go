package routers

import (
	"github.com/peanut996/timecapsule-go/controllers"
)

func CapsuleRouter() {
	r := Router.Group("/capsule")
	r.GET("/", controllers.GetAllCapsule)
	r.POST("/", controllers.AddCapsule)
	r.GET("/:uuid", controllers.GetCapsuleByUuid)
	r.PUT("/:uuid", controllers.UpdateCapsule)
	r.DELETE("/:uuid", controllers.DeleteCapsuleByUuid)
}
