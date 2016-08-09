<%@taglib prefix="e" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="wizard2" data-role="wizard2"
     data-button-labels='{"help": "?", "prev": "<span class=\"mif-arrow-left\"></span>", "next": "<span class=\"mif-arrow-right\"></span>", "finish": "<a href=\"groupView?groupID=${group.id}&userEmail=${user.email}\"><span class=\"mif-checkmark\"></span></a>"}'>

    <div class="step">
        <div class="step-content">
            <p class="text-small lowercase no-margin">Group Edit</p>
            <h1 class="no-margin-top sub-leader">Name</h1>
            <div class="grid">
                <div class="row">
                    <div class="cell">
                        <div class="input-control modern text iconic" data-role="input">
                            <input id="groupName" name="groupName" type="text" style="padding-right: 5px;" disabled value=${group.name}>
                            <span class="label">Your Group Name</span>
                            <span class="informer">Please enter your group name</span>
                            <span class="placeholder" style="display: block;">Public</span>
                            <a href="#" class="edit"><span class="mif-pencil"></span> Edit</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="text-small padding20 bg-grayLighter">
                Edit your Group Name.
            </div>
        </div>
    </div>

    <div class="step">
        <div class="step-content">
            <p class="text-small lowercase no-margin">Group Edit</p>
            <h1 class="no-margin-top sub-leader">People</h1>
            <div class="input-control text peopleSearch">
                <span class="mif-user prepend-icon"></span>
                <input type="text" value="" placeholder="Enter to search a user">
            </div>
            <div class="peopleEdit">
                <ul>
                    <e:forEach items="${gUsers}" var="user">
                        <li>
                            <a href="profileView?user=${user.email}">
                                <div class="panel">
                                    <div class="heading">
                                        <span class="icon mif-user"></span>
                                        <span class="title">${user.nickName}</span>
                                        <span class="mif-user-minus gentry"></span>
                                        <input type="hidden" value=${user.id} class="userID">
                                    </div>
                                </div>
                            </a>
                        </li>
                    </e:forEach>
                    <e:forEach items="${nonGUsers}" var="user">
                        <li>
                            <a href="profileView?user=${user.email}">
                                <div class="panel">
                                    <div class="heading">
                                        <span class="icon mif-user"></span>
                                        <span class="title">${user.nickName}</span>
                                        <span class="mif-user-plus gentry"></span>
                                        <input type="hidden" value=${user.id} class="userID">
                                    </div>
                                </div>
                            </a>
                        </li>
                    </e:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>
<script src="/resources/theme1/js/group_edit.js"></script>