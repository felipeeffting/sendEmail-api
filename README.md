<h1> Email - API </h1>

<h2> Overview </h2>
<p> 
This is a simple api sending email. Create <b>Java</b> with the <b>SPRING</b> framework.
<br/>
Please email felipe.motaeffting@gmail.com if you find any bugs or suggestion.
</p>

<h2> Sending Email </h2>
<p>
Sending the email is simple, you must send a <b>Json</b> in the <b>Post</b> method to url '/email/sendEmails'

These are json's body items:
<table>
<tr>
  <th> Field </th>
  <th> Description </th>
  <th> Type </th>
</tr>
<tr>
  <td> recipient </td>
  <td> Recipient for email </td>
  <td> String </td>
</tr>
<tr>
  <td> emissary </td>
  <td> Emissary for email </td>
  <td> String </td>
</tr>
<tr>
  <td> bodyText </td>
  <td> Text Body for email </td>
  <td> String </td>
</tr>
<tr>
  <td> subjectText </td>
  <td> Text Subject </td>
  <td> String </td>
 </tr>
</table>

For exemple:
<br/><b>Request:</b><br/>
```json
{
	"recipient": "felipe.motaeffting@gmail.comr",
	"emissary": "felipe.motaeffting@gmail.com",
	"bodyText": "api mail",
	"subjectText": "api mail"
}
```
<b>Response</b>
```json
{
   "path": "/email/sendEmails",
   "method": "post",
   "object": {
       "recipient": "felipe.motaeffting@gmail.com",
       "emissary": "felipe.motaeffting@gmail.com",
       "bodyText": "api mail",
       "subjectText": "api mail"
   }
}
```

<b> Remember that you must configure your GMAIL to accept less secure app access </b>
</p>

