# Enhancing-web-search-engine-using-Apache-solr
Implementing Autocomplete and spelling correction using Apache Solr

## Steps:

1.)	Wrote a Java program using Apache Tika to extract the text content from the body of the html pages of CNN news to a single document.

2.)	Saved the output as Big.txt which was later used for Norvig’s spell correction.

3.)	Wrote another Java program to extract the contents of the html downloaded files separately using html parser provided by Apache Tika and saved the text file with the original file name.

4.)	Downloaded Norvigs SpellCorrector.php and placed in on apache server along with the Big.txt and extracted file folder(output) mentioned in step 2, 3.

5.)	Made configuration changes to solrconfig.xml file as per the given guidelines.

6.)	Reloaded the core (myexample) to reflect the changes 

7.)	Modified the final.php file to include Norvigs the spellCorrector.

8.)	Wrote Autocomp.php containing the functions to provide list in sorted order. The front end final.php makes ajax calls to this file for giving autocomplete suggestions. 

9.)	The frontend also includes a jquery autocomplete function to retrieve results from the backend php file.

10.)	For autocomplete, the last word is taken into consideration for providing accurate suggestions. The first character produces up to 10 results, the second character produces up to 7 results and the subsequent characters produce up to 3 results.

11.)	For spelling correction, the frontend (final.php) divides the input query depending on the spaces. These individual words from the query are searched in the big.txt file for correction.

12.)	If an incorrect word is submitted by the user then the correct word along with the results are displayed in the browser.

13.)	For snippets, the individual query words are searched in the extracted document id files. Depending on the results, 20 characters are extracted before/after the query word from the document to display under the snippet. 
