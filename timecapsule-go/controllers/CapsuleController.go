package controllers

import (
	"github.com/gin-gonic/gin"
	"github.com/peanut996/timecapsule-go/models"
)

func GetAllCapsule(c *gin.Context) {
	capsules, err := models.GetAllCapsule()
	if err != nil {
		c.JSON(500, gin.H{
			"message": err.Error(),
		})
	} else {
		c.JSON(200, capsules)
	}
}

func GetCapsuleByUuid(c *gin.Context) {
	uuid := c.Param("uuid")
	capsule, err := models.GetCapsuleByUuid(uuid)
	if err != nil {
		c.JSON(500, gin.H{
			"message": err.Error(),
		})
	} else {
		c.JSON(200, capsule)
	}
}

func AddCapsule(c *gin.Context) {
	capsule := &models.Capsule{}
	if err := c.ShouldBindJSON(&capsule); err != nil {
		c.JSON(500, gin.H{
			"message": err.Error(),
		})
	} else {
		if err = models.AddCapsule(capsule); err != nil {
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

func UpdateCapsule(c *gin.Context) {
	capsule := &models.Capsule{}
	if err := c.ShouldBindJSON(&capsule); err != nil {
		c.JSON(500, gin.H{
			"message": err.Error(),
		})
	} else {
		if err = models.UpdateCapsule(capsule); err != nil {
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

func DeleteCapsuleByUuid(c *gin.Context) {
	uuid := c.Param("uuid")
	err := models.DeleteCapsuleByUuid(uuid)
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
