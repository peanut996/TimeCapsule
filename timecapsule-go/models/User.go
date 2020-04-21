package models

import "time"

//User is the entity of table user.
type User struct {
	ID        int       `json:"id" gorm:"primary_key;not null;auto_increment"`
	Username  string    `json:"username" gorm:"not null;unique" binding:"required"`
	Password  string    `json:"password" gorm:"not null" `
	Nickname  string    `json:"nickname" gorm:"DEFAULT:null"`
	Email     string    `json:"email" gorm:"not null"`
	Avatar    string    `json:"avatar"`
	CreatedAt time.Time `json:"createtime" gorm:"default:current_time;column:createtime"`
	UpdatedAt time.Time `json:"updatetime" gorm:"default:current_time;column:updatetime"`
}

//TableName Modify the table name for database.
func (User) TableName() string {
	return "user"
}

func GetAllUser() ([]*User, error) {
	users := make([]*User, 0)
	if err := db.Find(&users).Error; err != nil {
		return nil, err
	}
	return users, nil
}

func GetUserByUsername(username string) (*User, error) {
	user := &User{}
	if err := db.Where("username = ?", username).Find(user).Error; err != nil {
		return nil, err
	}
	return user, nil
}

func AddUser(user *User) error {
	if err := db.Create(user).Error; err != nil {
		return err
	}
	return nil
}

func DeleteUserByUsername(username string) error {
	if err := db.Where("username = ?", username).Delete(User{}).Error; err != nil {
		return err
	}
	return nil
}

//warning when save must hava the ID
func UpdateUser(user *User) error {
	olduser, err := GetUserByUsername(user.Username)
	if err != nil {
		return err
	}
	user.ID = olduser.ID
	if err := db.Save(user).Error; err != nil {
		return err
	}
	return nil
}
