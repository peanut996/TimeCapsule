package controllers

import (
	"github.com/gin-gonic/gin"
	"github.com/peanut996/timecapsule-go/models"
)

func GetAllAdmin(c *gin.Context) {
	admins, err := models.GetAllAdmin()
	if err != nil {
		c.JSON(500, gin.H{
			"message": err.Error(),
		})
	} else {
		c.JSON(200, admins)
	}

}

func GetAdminByAccount(c *gin.Context) {
	account := c.Param("account")
	admin, err := models.GetAdminByAccount(account)
	if err != nil {
		c.JSON(500, gin.H{
			"message": err.Error(),
		})
	} else {
		c.JSON(200, admin)
	}
}

func AddAdmin(c *gin.Context) {
	admin := &models.Admin{}
	if err := c.ShouldBindJSON(&admin); err != nil {
		c.JSON(500, gin.H{
			"message": err.Error(),
		})
	} else {

		if err = models.AddAdmin(admin); err != nil {
			c.JSON(200, gin.H{
				"message": err.Error(),
			})
		} else {
			c.JSON(200, gin.H{
				"message": "success",
			})
		}
	}
}

func UpdateAdmin(c *gin.Context) {
	admin := &models.Admin{}
	if err := c.ShouldBindJSON(&admin); err != nil {
		c.JSON(500, gin.H{
			"message": err.Error(),
		})
	} else {
		err := models.UpdateAdmin(admin)
		if err != nil {
			c.JSON(500, gin.H{
				"message": err.Error(),
			})
		} else {
			c.JSON(200, gin.H{
				"message": "success",
			})
		}
	}
}

func DeleteAdminByAccount(c *gin.Context) {
	account := c.Param("account")
	err := models.DeleteAdminByAccount(account)
	if err != nil {
		c.JSON(200, gin.H{
			"message": err.Error(),
		})
	} else {
		c.JSON(200, gin.H{
			"message": "success",
		})
	}
}
