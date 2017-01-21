PROJECT_ROOT=./
Q1DIR=$(PROJECT_ROOT)/question1
Q2DIR=$(PROJECT_ROOT)/question2
Q3DIR=$(PROJECT_ROOT)/question3
plot:

	@cd $(Q1DIR); \
	octave gradient_descent.m; \
	gnuplot plot.gnu; \ 
	rm input.dat; \
Project_proposal:
	@cd $(Q2DIR); \
	pdflatex ProjectProposal.tex; \
	bibtex ProjectProposal.aux; \
	pdflatex ProjectProposal.tex; \

GayatriMantra:
	@cd $(Q3DIR); \
	devnag GayatriMantra; \
	pdflatex GayatriMantra ; \ 

clean:
	rm $(Q3DIR)/GayatriMantra.aux; \
	rm $(Q3DIR)/GayatriMantra.tex; \
	rm $(Q3DIR)/GayatriMantra.pdf; \
	rm $(Q3DIR)/GayatriMantra.log; \
	rm $(Q2DIR)/ProjectProposal.run.xml; \
	rm $(Q2DIR)/ProjectProposal.log; \
	rm $(Q2DIR)/ProjectProposal.out; \
	rm $(Q2DIR)/ProjectProposal.blg; \
	rm $(Q2DIR)/ProjectProposal.bbl; \
	rm $(Q2DIR)/ProjectProposal.aux; \
	rm $(Q2DIR)/ProjectProposal.bcf; \
	rm $(Q2DIR)/ProjectProposal.pdf; \
	rm $(Q2DIR)/ProjectProposal-blx.bib; \
	rm $(Q1DIR)/plot.png; \
	rm $(Q1DIR)/output.dat; \
	rm $(Q1DIR)/input.dat; \