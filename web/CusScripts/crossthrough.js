    
function edValueKeyPress(){
    
    var myElement = document.getElementById('edValue');
myElement.onpaste = function(e) {
  var pastedText = undefined;
  if (window.clipboardData && window.clipboardData.getData) { // IE
    pastedText = window.clipboardData.getData('Text');
  } else if (e.clipboardData && e.clipboardData.getData) {
    pastedText = e.clipboardData.getData('text/plain');
  }
  //alert(pastedText); // Process and handle text...
  ref='';
  while(ref==null||ref==''){
   ref =prompt("Please enter a Reference","");
}
  //alert(ref.length)
  if(ref!=null||ref!=''){
      
    insertHtmlAtCursor('<p style=\"color:red; background:yellow; font:italic bold 12px/30px Georgia,serif;\">'+pastedText+'<br> Reference: '+ref+'</p>')
  }
  return false; // Prevent the default handler from running.
};
   
   
}
    
    function insertHtmlAtCursor(html) {
    var range, node;
    if (window.getSelection && window.getSelection().getRangeAt) {
        range = window.getSelection().getRangeAt(0);
        node = range.createContextualFragment(html);
        range.insertNode(node);
    } else if (document.selection && document.selection.createRange) {
        document.selection.createRange().pasteHTML(html);
    }
}
  
function getSelectionHtml() {
    var html = "";
    if (typeof window.getSelection != "undefined") {
        var sel = window.getSelection();
        if (sel.rangeCount) {
            var container = document.createElement("div");
            for (var i = 0, len = sel.rangeCount; i < len; ++i) {
                container.appendChild(sel.getRangeAt(i).cloneContents());
            }
            html = container.innerHTML;
        }
    } else if (typeof document.selection != "undefined") {
        if (document.selection.type == "Text") {
            html = document.selection.createRange().htmlText;
        }
    }
    var el=document.getElementById("edValue");
    if(html.length==0 && el.innerText.length==getCaretCharacterOffset(el)){
        html=getCaretCharacterOffsetWithin(el)
        replaceSelectionWithHtml('<del>'+html+'</del>&nbsp;')
    }
    
    else if(html.length==0){
        
        html=getCaretCharacterOffsetWithin(el)
        replaceSelectionWithHtml('<del>'+html+'</del>')
        
    }
    else{
        replaceSelectionWithHtml('<del>'+html+'</del>&nbsp;')
    }
      //  alert(document.getElementById("edValue").innerText)
}


function getSelectionHtmlDel() {
    var html = "";
    
    if (typeof window.getSelection != "undefined") {
        var sel = window.getSelection();
        if (sel.rangeCount) {
            var container = document.createElement("div");
            for (var i = 0, len = sel.rangeCount; i < len; ++i) {
                container.appendChild(sel.getRangeAt(i).cloneContents());
            }
            html = container.innerHTML;
        }
    } else if (typeof document.selection != "undefined") {
        if (document.selection.type == "Text") {
            html = document.selection.createRange().htmlText;
        }
    }
    
    var el=document.getElementById("edValue");
    
    if(html.length==0){
        
        var x=getCaretCharacterOffset(el)
        html=el.innerText.charAt(x)
       // alert(html)
        replaceSelectionWithHtml('<del>'+html+'</del>')
        
    }
    else{
        replaceSelectionWithHtml('<del>'+html+'</del>&nbsp;')
    }
       // alert(document.getElementById("edValue").innerHTML)
}

function replaceSelectionWithHtml(html) {
    var range, html;
    if (window.getSelection && window.getSelection().getRangeAt) {
        range = window.getSelection().getRangeAt(0);
        range.deleteContents();
        var div = document.createElement("div");
        div.innerHTML = html;
        var frag = document.createDocumentFragment(), child;
        while ( (child = div.firstChild) ) {
            frag.appendChild(child);
        }
        range.insertNode(frag);
    } else if (document.selection && document.selection.createRange) {
        range = document.selection.createRange();
        html = (node.nodeType == 3) ? node.data : node.outerHTML;
        range.pasteHTML(html);
    }
}


function getCaretCharacterOffset(element) {
    var caretOffset = 0;
    var doc = element.ownerDocument || element.document;
    var win = doc.defaultView || doc.parentWindow;
    var sel;
    if (typeof win.getSelection != "undefined") {
        var range = win.getSelection().getRangeAt(0);
        var preCaretRange = range.cloneRange();
        preCaretRange.selectNodeContents(element);
        preCaretRange.setEnd(range.endContainer, range.endOffset);
        caretOffset = preCaretRange.toString().length;//
    } else if ( (sel = doc.selection) && sel.type != "Control") {
        var textRange = sel.createRange();
        var preCaretTextRange = doc.body.createTextRange();
        preCaretTextRange.moveToElementText(element);
        preCaretTextRange.setEndPoint("EndToEnd", textRange);
        caretOffset = preCaretTextRange.text.length;//
    }
    return caretOffset;
}


function getCaretCharacterOffsetWithin(element) {
    var caretOffset = 0;
    var doc = element.ownerDocument || element.document;
    var win = doc.defaultView || doc.parentWindow;
    var sel;
    if (typeof win.getSelection != "undefined") {
        var range = win.getSelection().getRangeAt(0);
        var preCaretRange = range.cloneRange();
        preCaretRange.selectNodeContents(element);
        preCaretRange.setEnd(range.endContainer, range.endOffset);
        caretOffset = preCaretRange.toString();//
    } else if ( (sel = doc.selection) && sel.type != "Control") {
        var textRange = sel.createRange();
        var preCaretTextRange = doc.body.createTextRange();
        preCaretTextRange.moveToElementText(element);
        preCaretTextRange.setEndPoint("EndToEnd", textRange);
        caretOffset = preCaretTextRange.text;//
    }
    return caretOffset.charAt(caretOffset.length-1);
}



function showCaretPos() {
    var KeyID = event.keyCode;
   switch(KeyID)
   {
      case 8:
      //alert("backspace");
      getSelectionHtml();
      return false;
      break; 
      case 46: 
      getSelectionHtmlDel();    
      return false;
      break;
      default:
      break;
   }
    var el = document.getElementById("edValue");
    var caretPosEl = document.getElementById("caretPos");
    caretPosEl.innerHTML = "Caret position: " + getCaretCharacterOffsetWithin(el);
}
