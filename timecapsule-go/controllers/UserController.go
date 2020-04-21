package controllers

import (
	"github.com/gin-gonic/gin"
	"github.com/peanut996/timecapsule-go/models"
)

func GetAllUser(c *gin.Context) {
	users, err := models.GetAllUser()
	if err != nil {
		c.JSON(500, gin.H{
			"message": err.Error(),
		})
	} else {
		c.JSON(200, users)
	}
}

func GetUserByUsername(c *gin.Context) {
	username := c.Param("username")
	user, err := models.GetUserByUsername(username)
	if err != nil {
		c.JSON(500, gin.H{
			"message": err.Error(),
		})
	} else {
		c.JSON(200, user)
	}
}

func AddUser(c *gin.Context) {
	user := &models.User{}
	if err := c.ShouldBindJSON(&user); err != nil {
		c.JSON(500, gin.H{
			"message": err.Error(),
		})
	} else {
		if err = models.AddUser(user); err != nil {
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

func DeleteUserByUsername(c *gin.Context) {
	username := c.Param("username")
	err := models.DeleteUserByUsername(username)
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

func UpdateUser(c *gin.Context) {
	user := &models.User{}
	if err := c.ShouldBindJSON(&user); err != nil {
		c.JSON(500, gin.H{
			"message": err.Error(),
		})
	} else {
		if err = models.UpdateUser(user); err != nil {
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
