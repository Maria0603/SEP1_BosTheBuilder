//Details for Residential Projects
$.get("xml/ongoing.xml", function (xml, status) {
    var txt = "";
    $(xml).find("Residential").each(function () {
        var id = $(this).find("id").text();
        var title = $(this).find("title").text();
        var SquareMeters = $(this).find("SquareMeters").text();
        var NumberOfKitchens = $(this).find("NumberOfKitchens").text();
        var NumberOfBathrooms = $(this).find("NumberOfBathrooms").text();
        var NumberOfPlumbingRooms = $(this).find("NumberOfPlumbingRooms").text();
        var IsNew = $(this).find("IsNew").text();
        var ExpectedBudget = $(this).find("ExpectedBudget").text();
        var SpentBudget = $(this).find("SpentBudget").text();
        var ExpectedMonths = $(this).find("ExpectedMonths").text();
        var SpentMonths = $(this).find("SpentMonths").text();
        var IsFinished = $(this).find("IsFinished").text();
        var CreationDateString = $(this).find("CreationDateString").text();
        var EndingDateString = $(this).find("EndingDateString").text();
        
        txt += " id: " + id + "<br>";
        txt += "title: " + title + "<br>";
        txt += "SquareMeters: " + SquareMeters + "<br>";
        txt += "NumberOfKitchens: " + NumberOfKitchens + "<br>";
        txt += "NumberOfBathrooms: " + NumberOfBathrooms + "<br>";
        txt += "NumberOfPlumbingRooms: " + NumberOfPlumbingRooms + "<br>";
        txt += "IsNew: " + IsNew + "<br>";
        txt += "ExpectedBudget: " + ExpectedBudget + "<br>";
        txt += "SpentBudget: " + SpentBudget + "<br>";
        txt += "ExpectedMonths: " + ExpectedMonths + "<br>";
        txt += "SpentMonths: " + SpentMonths + "<br>";
        txt += "IsFinished: " + IsFinished + "<br>";
        txt += "CreationDateString: " + CreationDateString + "<br>";
        txt += "EndingDateString: " + EndingDateString + "<br>";
       
    });
    $(".residentialProjects").html(txt);
});

//Details for Commercial Projects
$.get("xml/ongoing.xml", function (xml, status) {
    var txt = "";
    $(xml).find("Commercial").each(function () {
        var id = $(this).find("id").text();
        var title = $(this).find("title").text();
        var SquareMeters = $(this).find("SquareMeters").text();
        var NumberOfFloors = $(this).find("NumberOfFloors").text();
        var UsedFor = $(this).find("UsedFor").text();
        var ExpectedBudget = $(this).find("ExpectedBudget").text();
        var SpentBudget = $(this).find("SpentBudget").text();
        var ExpectedMonths = $(this).find("ExpectedMonths").text();
        var SpentMonths = $(this).find("SpentMonths").text();
        var IsFinished = $(this).find("IsFinished").text();
        var CreationDateString = $(this).find("CreationDateString").text();
        var EndingDateString = $(this).find("EndingDateString").text();

        txt += "id: " + id + "<br>";
        txt += "title: " + title + "<br>";
        txt += "SquareMeters: " + SquareMeters + "<br>";
        txt += "NumberOfFloors: " + NumberOfFloors + "<br>";
        txt += "UsedFor: " + UsedFor + "<br>";
        txt += "ExpectedBudget: " + ExpectedBudget + "<br>";
        txt += "SpentBudget: " + SpentBudget + "<br>";
        txt += "ExpectedMonths: " + ExpectedMonths + "<br>";
        txt += "SpentMonths: " + SpentMonths + "<br>";
        txt += "IsFinished: " + IsFinished + "<br>";
        txt += "CreationDateString: " + CreationDateString + "<br>";
        txt += "EndingDateString: " + EndingDateString + "<br>";
    });
    $(".commercialProjects").html(txt);
});

//Details for industrial Projects
$.get("xml/ongoing.xml", function (xml, status) {
    var txt = "";
    $(xml).find("Industrial").each(function () {
        var id = $(this).find("id").text();
        var title = $(this).find("title").text();
        var SquareMeters = $(this).find("SquareMeters").text();
        var UsedFor = $(this).find("UsedFor").text();
        var ExpectedBudget = $(this).find("ExpectedBudget").text();
        var SpentBudget = $(this).find("SpentBudget").text();
        var ExpectedMonths = $(this).find("ExpectedMonths").text();
        var SpentMonths = $(this).find("SpentMonths").text();
        var IsFinished = $(this).find("IsFinished").text();
        var CreationDateString = $(this).find("CreationDateString").text();
        var EndingDateString = $(this).find("EndingDateString").text();

        txt += "id: " + id + "<br>";
        txt += "title: " + title + "<br>";
        txt += "SquareMeters: " + SquareMeters + "<br>";
        txt += "UsedFor: " + UsedFor + "<br>";
        txt += "ExpectedBudget: " + ExpectedBudget + "<br>";
        txt += "SpentBudget: " + SpentBudget + "<br>";
        txt += "ExpectedMonths: " + ExpectedMonths + "<br>";
        txt += "SpentMonths: " + SpentMonths + "<br>";
        txt += "IsFinished: " + IsFinished + "<br>";
        txt += "CreationDateString: " + CreationDateString + "<br>";
        txt += "EndingDateString: " + EndingDateString + "<br>";
    });
    $(".industrialProjects").html(txt);
});


//Details for road construction
$.get("xml/ongoing.xml", function (xml, status) {
    var txt = "";
    $(xml).find("Road").each(function () {
        var id = $(this).find("id").text();
        var title = $(this).find("title").text();
        var Length = $(this).find("Length").text();
        var Width = $(this).find("Width").text();
        var NumberOfBridges = $(this).find("NumberOfBridges").text();
        var NumberOfTunnels = $(this).find("NumberOfTunnels").text();
        var EnvironmentalChallenges = $(this).find("EnvironmentalChallenges").text();
        var ExpectedBudget = $(this).find("ExpectedBudget").text();
        var SpentBudget = $(this).find("SpentBudget").text();
        var ExpectedMonths = $(this).find("ExpectedMonths").text();
        var SpentMonths = $(this).find("SpentMonths").text();
        var IsFinished = $(this).find("IsFinished").text();
        var CreationDateString = $(this).find("CreationDateString").text();
        var EndingDateString = $(this).find("EndingDateString").text();

      
        txt += "id: " + id + "<br>";
        txt += "title: " + title + "<br>";
        txt += "Length: " + Length + "<br>";
        txt += "Width: " + Width + "<br>";
        txt += "NumberOfBridges: " + NumberOfBridges + "<br>";
        txt += "NumberOfTunnels: " + NumberOfTunnels + "<br>";
        txt += "EnvironmentalChallenges: " + EnvironmentalChallenges + "<br>";
        txt += "ExpectedBudget: " + ExpectedBudget + "<br>";
        txt += "SpentBudget: " + SpentBudget + "<br>";
        txt += "ExpectedMonths: " + ExpectedMonths + "<br>";
        txt += "SpentMonths: " + SpentMonths + "<br>";
        txt += "IsFinished: " + IsFinished + "<br>";
        txt += "CreationDateString: " + CreationDateString + "<br>";
        txt += "EndingDateString: " + EndingDateString + "<br>";
    });
    $(".roadConstruction").html(txt);
});


