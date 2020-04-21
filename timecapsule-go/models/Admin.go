package models

type Admin struct {
	ID          int    `json:"id" gorm:"primary_key;not null;auto_increment"`
	Account     string `json:"account" gorm:"not null;unique" binding:"required"`
	Password    string `json:"password" gorm:"not null"`
	Description string `json:"description" gorm:"default:null"`
	Avatar      string `json:"avatar" gorm:"default:null"`
}

func (Admin) TableName() string {
	return "admin"
}
func GetAllAdmin() ([]*Admin, error) {
	admins := make([]*Admin, 0)
	err := db.Find(&admins).Error
	if err != nil {
		return nil, err
	}
	return admins, nil
}

func GetAdminByAccount(account string) (*Admin, error) {
	admin := &Admin{}
	err := db.Where("account = ? ", account).Find(&admin).Error
	if err != nil {
		return nil, err
	}
	return admin, nil
}

func UpdateAdmin(admin *Admin) error {
	oldadmin, err := GetAdminByAccount(admin.Account)
	if err != nil {
		return err
	}
	admin.ID = oldadmin.ID
	if err := db.Save(admin).Error; err != nil {
		return err
	}
	return nil
}

func AddAdmin(admin *Admin) error {
	err := db.Create(admin).Error
	if err != nil {
		return err
	}
	return nil
}

func DeleteAdminByAccount(account string) error {
	err := db.Where("account = ?", account).Delete(Admin{}).Error
	if err != nil {
		return err
	}
	return nil
}
