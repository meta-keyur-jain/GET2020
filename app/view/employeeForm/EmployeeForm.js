/**
 * @className EmployeeForm
 * @description
 * It display the form for new entry of employee.
 * It includes email,profilePic,name,project,college,academic and work experience details.
 * It also include search field to search by name.
 */
Ext.define('NewApp.view.employeeForm.EmployeeForm', {
    extend: 'Ext.form.Panel',
    xtype: 'employeeRegister',
    requires: [
        'NewApp.view.employeeForm.EmployeeFormController',
        'NewApp.view.employeeForm.EmployeeFormModel'
    ],

    controller: 'employeeform-employeeform',
    viewModel: {
        type: 'employeeform-employeeform'
    },


    align: 'right',
    bodyPadding: 20,
    scrollable: 'y',
    autoSize: true,
    cls: 'employeeForm',
    items: [{

            xtype: 'titlebar',
            title: 'Employee Details',
            items: [{
                xtype: 'button',
                xtype: 'button',
                iconCls: 'fa-2x fa-times-circle',
                align: 'right',
                cls: 'closeButton',
                handler: 'closeForm'
            }]

        }, {
            xtype: 'textfield',
            name: 'employeeName',
            itemId: 'name',
            width: '100%',
            emptyText: 'Name',
            placeHolder: "Name",
            allowBlank: false,
            required: true
        },
        {
            xtype: 'emailfield',
            name: 'employeeEmail',
            itemId: 'email',
            placeHolder: 'Email',
            allowBlank: false,
            required: true,
            width: '100%',
            validators: 'email'
        },
        {
            xtype: 'textfield',
            name: 'employeeProject',
            placeHolder: 'Project Name',
            width: '100%',
            itemId: 'project',
            allowBlank: false,
            required: true
        },
        {
            xtype: 'textfield',
            name: 'employeeProfilePic',
            placeHolder: 'Photo URL',
            width: '100%',
            itemId: 'photo',
            allowBlank: false,
            required: true
        }, {
            cls: 'basicDetails',
            xtype: 'fieldset',
            title: 'School Details',
            width: '100%',
            items: [{
                xtype: 'numberfield',
                name: 'employeeClassX',
                placeHolder: 'Class X',
                itemId: 'persantX',
                width: '100%',
                maxValue: 100,
                minValue: 0,
                hideTrigger: true,
                keyNavEnabled: false,
                mouseWheelEnabled: false
            }, {
                xtype: 'numberfield',
                name: 'employeeClassXII',
                width: '100%',
                placeHolder: 'Class XII',
                itemId: 'persantXII',
                maxValue: 100,
                minValue: 0,
                hideTrigger: true,
                keyNavEnabled: false,
                mouseWheelEnabled: false
            }]
        },
        {
            cls: 'basicDetails',
            xtype: 'fieldset',
            border: true,
            width: '100%',
            title: 'College Details',
            items: [{
                xtype: 'numberfield',
                name: 'employeeCollegeMarks',
                placeHolder: 'Aggegrate %',
                width: '100%',
                itemId: 'aggregate',
                maxValue: 100,
                minValue: 0,
                hideTrigger: true,
                keyNavEnabled: false,
                mouseWheelEnabled: false
            }]
        },
        {
            cls: 'basicDetails',
            xtype: 'fieldset',
            title: 'Work Experience Details',
            width: '100%',
            items: [{
                xtype: 'textfield',
                name: 'employeeCompanyName',
                placeHolder: 'Previous Company',
                itemId: 'companyName'
            }, {
                xtype: 'numberfield',
                name: 'employeeExperience',
                itemId: 'experience',
                placeHolder: 'Experience(in years)',
                width: '100%',
                maxValue: 100,
                minValue: 0,
                hideTrigger: true,
                keyNavEnabled: false,
                mouseWheelEnabled: false
            }]
        }, {
            xtype: 'button',
            text: 'Register',
            listeners: {
                tap: 'onRegister'
            }
        }
    ]
});