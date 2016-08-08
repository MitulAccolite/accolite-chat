<div class="wizard2" data-role="wizard2"
     data-button-labels='{"help": "?", "prev": "<span class=\"mif-arrow-left\"></span>", "next": "<span class=\"mif-arrow-right\"></span>", "finish": "<a href=\"userprofile\"><span class=\"mif-checkmark\"></span></a>"}'>

    <div class="step">
        <div class="step-content">
            <p class="text-small lowercase no-margin">Profile Edit</p>
            <h1 class="no-margin-top sub-leader">Name</h1>
            <div class="grid">
                <div class="row">
                    <div class="cell">
                        <div class="input-control modern text iconic" data-role="input">
                            <input id="firstName" name="firstName" type="text" style="padding-right: 5px;" disabled value="Harry">
                            <span class="label">Your First Name</span>
                            <span class="informer">Please enter your first name</span>
                            <span class="placeholder" style="display: block;">Harry</span>
                            <a href="#" class="edit"><span class="mif-pencil"></span> Edit</a>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="cell">
                        <div class="input-control modern text iconic" data-role="input">
                            <input id="middleName" name="middleName" type="text" style="padding-right: 5px;" disabled value="James">
                            <span class="label">Your Middle Name</span>
                            <span class="informer">Please enter your middle name</span>
                            <span class="placeholder" style="display: block;">James</span>
                            <a href="#" class="edit"><span class="mif-pencil"></span> Edit</a>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="cell">
                        <div class="input-control modern text iconic" data-role="input">
                            <input id="lastName" name="lastName" type="text" style="padding-right: 5px;" disabled value="Potter">
                            <span class="label">Your last Name</span>
                            <span class="informer">Please enter your last name</span>
                            <span class="placeholder" style="display: block;">Potter</span>
                            <a href="#" class="edit"><span class="mif-pencil"></span> Edit</a>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="cell">
                        <div class="input-control modern text iconic" data-role="input">
                            <input id="nickName" name="nickName" type="text" style="padding-right: 5px;" disabled value="Parry Hotter">
                            <span class="label">Your nick Name</span>
                            <span class="informer">Please enter your nick name</span>
                            <span class="placeholder" style="display: block;">Parry Hotter</span>
                            <a href="#" class="edit"><span class="mif-pencil"></span> Edit</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="text-small padding20 bg-grayLighter">
                Edit your First Name, Middle Name, Last Name and Nick Name.
            </div>
        </div>
    </div>
    <div class="step">
        <div class="step-content">
            <p class="text-small lowercase no-margin">Profile Edit</p>
            <h1 class="no-margin-top sub-leader">Contact</h1>
            <div class="grid">
                <div class="row">
                    <div class="cell">
                        <div class="input-control modern text iconic" data-role="input">
                            <input id="userMobile" name="userMobile" type="number" style="padding-right: 5px;" disabled value="1234567890">
                            <span class="label">Your Mobile Number</span>
                            <span class="informer">Please enter 10 digit mobile no.</span>
                            <span class="input-state-error mif-warning"></span>
                            <span class="input-state-success mif-checkmark"></span>
                            <a href="#" class="edit"><span class="mif-pencil"></span> Edit</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="text-small padding20 bg-grayLighter">
                Edit your contact number.
            </div>
        </div>
    </div>
    <div class="step">
        <div class="step-content">
            <p class="text-small lowercase no-margin">Profile Edit</p>
            <h1 class="no-margin-top sub-leader">Groups</h1>
            <div class="groupedit">
                <ul>
                    <li>
                        <a href="grouplink">
                            <div class="panel">
                                <div class="heading">
                                    <span class="icon mif-user"></span>
                                    <span class="title">Public</span>
                                    <span class="mif-exit leaveg"></span>
                                    <input type="hidden" value="1" class="groupID">
                                </div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="grouplink">
                            <div class="panel">
                                <div class="heading">
                                    <span class="icon mif-user"></span>
                                    <span class="title">Public</span>
                                    <span class="mif-exit leaveg"></span>
                                    <input type="hidden" value="2" class="groupID">
                                </div>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<script src="/resources/theme1/js/profile_edit.js"></script>