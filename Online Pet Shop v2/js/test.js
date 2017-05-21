$(function () {
  // Grab the template script
  var theTemplateScript = $("#example-template").html();

  // Compile the template
  var theTemplate = Handlebars.compile(theTemplateScript);

  // This is the default context, which is passed to the template
  var context = {
    people: [ 
      { PetDescription:'much dog, very wow', PetSpecies: 'Dog', PetPrice: '18' ,PetImage:'http://nebula.wsimg.com/fde0932bcaa022ec5a2ddba37d0b7d53?AccessKeyId=E8BC749E3F4CB56C9160&disposition=0&alloworigin=1'},
      {	PetDescription:'furry little fuck' , PetSpecies: 'Cat', PetPrice: '15',PetImage:'https://cdn.suwalls.com/wallpapers/animals/fluffy-kitten-33240-400x250.jpg' },
      { PetDescription:'annoying cunt' , PetSpecies: 'Parrot', PetPrice: '13' ,PetImage:'https://metrouk2.files.wordpress.com/2010/09/article-1284578597615-0b3299c9000005dc-693423_636x398.jpg'},
      { PetDescription:'chill dude' , PetSpecies: 'Geko', PetPrice: '12' ,PetImage:'http://www.clhsonline.net/loc_web/animals/herps/images/leopard_gecko.jpg'},
      { PetDescription:'basically a glorified rat' ,  PetSpecies: 'Hamster', PetPrice: '11' ,PetImage:'https://vetstreet-brightspot.s3.amazonaws.com/d9/00/32f17d09417d959a2ae35e479ddb/hamster-in-a-cage-thinkstockphotos-146960067.jpg' },
	  { PetDescription:'much dog, very wow', PetSpecies: 'Dog', PetPrice: '18' ,PetImage:'http://nebula.wsimg.com/fde0932bcaa022ec5a2ddba37d0b7d53?AccessKeyId=E8BC749E3F4CB56C9160&disposition=0&alloworigin=1'},
      {	PetDescription:'furry little fuck' , PetSpecies: 'Cat', PetPrice: '15',PetImage:'https://cdn.suwalls.com/wallpapers/animals/fluffy-kitten-33240-400x250.jpg' },
      { PetDescription:'annoying cunt' , PetSpecies: 'Parrot', PetPrice: '13' ,PetImage:'https://metrouk2.files.wordpress.com/2010/09/article-1284578597615-0b3299c9000005dc-693423_636x398.jpg'},
      { PetDescription:'chill dude' , PetSpecies: 'Geko', PetPrice: '12' ,PetImage:'http://www.clhsonline.net/loc_web/animals/herps/images/leopard_gecko.jpg'},
      { PetDescription:'basically a glorified rat' ,  PetSpecies: 'Hamster', PetPrice: '11' ,PetImage:'http://pad2.whstatic.com/images/thumb/0/0e/Play-With-a-Hamster-Step-5-Version-2.jpg/aid7339-v4-900px-Play-With-a-Hamster-Step-5-Version-2.jpg' },
	  { PetDescription:'much dog, very wow', PetSpecies: 'Dog', PetPrice: '18' ,PetImage:'http://nebula.wsimg.com/fde0932bcaa022ec5a2ddba37d0b7d53?AccessKeyId=E8BC749E3F4CB56C9160&disposition=0&alloworigin=1'},
      {	PetDescription:'furry little fuck' , PetSpecies: 'Cat', PetPrice: '15',PetImage:'https://cdn.suwalls.com/wallpapers/animals/fluffy-kitten-33240-400x250.jpg' },
      { PetDescription:'annoying cunt' , PetSpecies: 'Parrot', PetPrice: '13' ,PetImage:'https://metrouk2.files.wordpress.com/2010/09/article-1284578597615-0b3299c9000005dc-693423_636x398.jpg'},
      { PetDescription:'chill dude' , PetSpecies: 'Geko', PetPrice: '12' ,PetImage:'http://www.clhsonline.net/loc_web/animals/herps/images/leopard_gecko.jpg'},
      { PetDescription:'basically a glorified rat' ,  PetSpecies: 'Hamster', PetPrice: '11' ,PetImage:'https://vetstreet-brightspot.s3.amazonaws.com/d9/00/32f17d09417d959a2ae35e479ddb/hamster-in-a-cage-thinkstockphotos-146960067.jpg' }
	
    ]
  };

  // Pass our data to the template
  var theCompiledHtml = theTemplate(context);

  // Add the compiled html to the page
  $(document.body).append(theCompiledHtml);
});