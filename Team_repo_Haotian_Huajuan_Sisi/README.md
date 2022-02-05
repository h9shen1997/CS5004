# Team_repo_Haotian_Huajuan_Sisi

Repo for team assignments (HW7, HW8, HW9.)

**Link to our design HW7 Google
doc:** https://docs.google.com/document/d/1IFWIVTNfeb8J5PPpnGTYPxnGM00vEHcuc_EjQDjx_Ag/edit?usp=sharing

Ways to create a repo:

```
echo "# CS5004_HW7" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.ccs.neu.edu/h9shen/CS5004_HW7.git
git push -u origin main 
```

From the above command, the main branch is called main. This main branch is where we merge our own
branch to when the code is workable.

## How we should collaborate to make this HW a seamless process:

**Rule of thumb**

Create new branches for new features and merge them into main branch when they are completed and
workable. Make sure that the features we work on do not overlap, so that one's code won't affect the
work in progress of another person.

## How to create a new branch from your local folder:

```git checkout -b new_branch_name```

Here, checkout is used to switch between branches. Adding the -b flag creates a new branch and then
moves into that new branch for us.

## How to verify the branch is created:

```git branch```

**Remember to git add frequently and git commit when you finish something that allows your code to
work. For example, when you finish a method and the code base works, use the below command line:**

```git commit -m "Added a new function that works"```

Once you are done with your part of the code, use the below command line to create a pull request:

```git push ```

Now, if you go to the GitHub repo page, you should see the branch you pushed up in a yellow bar at
the top of the page with a button to _"Compare & pull request"_. Click this, and it will take you to
the _"Open a pull request"_ page. From here, you should write a brief description of what you
actually changed. Then, click the reviewer tab and select the person to review the code, and then
click _"Create pull request"_.

Since everyone is a collaborator for this homework, you can merge your own pull requests. Go to the
bottom of the pull request and click _"Merge pull request"_. And you will see a _"Pull request
successfully merged and closed"_ message and a button to _"Delete branch"_, which you should click
to delete that feature branch.

Everything beyond is just repetition, adding new branch for new features and push that branch to the
main branch and then merge it.

**One thing to keep in mind is that "DO NOT TRY TO MERGE MORE THAN ONE BRANCH AT A TIME!".**

## In case you made a mistake and want to go back to the previous commit, use the following command line:

```
git reset --hard
```

## Happy collaborating!
