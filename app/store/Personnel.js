Ext.define('NewApp.store.Personnel', {
    extend: 'Ext.data.Store',

    alias: 'store.personnel',

    fields: [
        'name', 'email', 'phone'
    ]

    // data: {
    //     items: [{
    //             'name': 'shubham',
    //             'email': 'shubham.gupta@metacube.com',
    //             'profilePic': 'https://www.google.com/s2/u/0/photos/public/AIbEiAIAAABDCI-GqebKrcePLSILdmNhcmRfcGhvdG8qKDk0ZDMyOWRiOTAwMTY4ZDVmZWY5MDhiODZlNzg5MGMwMWFkNGNkNGQwATL-UbwQPyBhu0ZAD4FTO7Nd7sgs?sz=40'
    //         },
    //         {
    //             'name': 'keyur',
    //             'email': 'keyur.jain@metacube.com',
    //             'profilePic': 'https://lh3.googleusercontent.com/a-/AOh14GgLQsAeQROhQ-BLFalOYNBmbstPL3PF2o8PPVPF=s28-c-k-no'
    //         }, {
    //             'name': 'rahul',
    //             'email': 'rahul.kumar2@metacube.com',
    //             'profilePic': 'https://lh4.googleusercontent.com/-7cQBIvbmPsM/AAAAAAAAAAI/AAAAAAAAABI/KhJAFAertUUPMEHZ_KazWqkxB8ohmH20gCLcDEAE/s32-c-k-no/photo.jpg'
    //         }, {
    //             'name': 'kunal',
    //             'email': 'kunal.gupta@metacube.com',
    //             'profilePic': 'https://lh3.googleusercontent.com/-4j8r78nL7Nc/AAAAAAAAAAI/AAAAAAAAAF8/JNtb1gKBTIcvnjuibbt3D8_LIg0EnNoGgCLcDEAE/s32-c-k-no/photo.jpg'
    //         },

    //     ]
    //},

    // proxy: {
    //     type: 'memory',
    //     reader: {
    //         type: 'json',
    //         rootProperty: 'items'
    //     }
    // }
});