package routers

import "github.com/peanut996/timecapsule-go/controllers"

func AdminRouter() {
	r := Router.Group("/admin")
	r.GET("/", controllers.GetAllAdmin)
	r.POST("/", controllers.AddAdmin)
	r.GET("/:account", controllers.GetAdminByAccount)
	r.PUT("/:account", controllers.UpdateAdmin)
	r.DELETE("/:account", controllers.DeleteAdminByAccount)

}
