html-parser
===========

<h2>Purpose: </h2> <p>To quickly isolate and return desired information buried in an HTML file</p>
<h2>Design: </h2>A user passes a URL and an ArrayList of objects implementing the interface TagHandler to an instance of the class ReportLoader. The instance of ReportLoader then downloads the raw HTML file and recursively iterates through the hierarchy of tags. When ReportLoader finds a tag that it has a TagHandler subclass for, it calls the TagHandler's handleContent() method for processing. When ReportLoader is done parsing, it calls getReport() on all its TagHandler's and returns an array of Report objects.  </p>
<h2>Classes: </h2>  <p>
<h5>ReportLoader: </h5><p>The main workhorse that iterates through the messy html. Called into action with the run() method.</p>
<h5>TagHandler: </h5><p>An interface for objects (e.g. DivHandler) that can be passed to a ReportLoader instance that has the ability to handle the data contained within a certain tag (e.g. &lt;table&gt;). When an instance of ReportLoader encounters an html tag that it has a TagHandler for, it will call the TagHandler instance's handleContent() method, passing the data between the tags of interest and the enclosing tags (a TagHandler instance can ensure it has found the data it's looking for by inspecting the surrounding tags and attributes). The TagHandler will store the data it collects from the many calls it receives from ReportLoader so that it can generate a Report object containing all its data. An array of Report objects will be returned to the client by ReportLoader after it is done parsing the entire html file.</p>
<h5>Report: </h5><p>An interface for data objects (e.g. WikipediaReport) that are returned by a TagHandler. When ReportLoader has finished parsing the whole html document, it calls the getReport() method on all of its TagHandler objects, and returns all of them in an array. It is up to the user to design how a Report instance structures its data.</p>
<h5>Tag: </h5><p> The Tag class is a more representative way to identify html tags instead of using plain strings. They hold all of the tag's attributes in a Hashtable. Knowing the tag's attributes makes it easier for a TagHandler subclass to know whether or not the data surrounded by tags of interest is of use.</p>
   </p>

